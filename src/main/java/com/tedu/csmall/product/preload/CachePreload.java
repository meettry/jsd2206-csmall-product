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


    public CachePreload() {
        log.debug("创建ApplicationRunner接口的实现对象:CachePreload");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("开始处理缓存预热");


    }
}
