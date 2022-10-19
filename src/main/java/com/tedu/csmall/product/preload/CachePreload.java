package com.tedu.csmall.product.preload;

import com.tedu.csmall.product.mapper.BrandMapper;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import com.tedu.csmall.product.repo.BrandRedisRepository;
import com.tedu.csmall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CachePreload implements ApplicationRunner {
    @Autowired
    BrandRedisRepository brandRedisRepository;
    @Autowired
    BrandMapper brandMapper;

    public CachePreload() {
        log.debug("创建ApplicationRunner接口的实现对象:CachePreload");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("开始处理缓存预热");

        log.debug("删除缓存中原有的品牌数据");
        Long result = brandRedisRepository.deleteAll();
        log.debug("共删除{}条数据",result);

        log.debug("从mapper中读取品牌列表");
        List<BrandListItemVO> list = brandMapper.list();

        log.debug("将品牌列表写入到Redis");
        brandRedisRepository.save(list);

        log.debug("逐一根据id从MySQL中读取品牌详情,并写入到Redis");
        for (BrandListItemVO item : list) {
            BrandStandardVO brand = brandMapper.getStandardById(item.getId());
            brandRedisRepository.save(brand);
        }
    }
}
