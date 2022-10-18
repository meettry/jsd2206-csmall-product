package com.tedu.csmall.product.repo.impl;

import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import com.tedu.csmall.product.repo.BrandRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class BrandRedisRepositoryImpl implements BrandRedisRepository {

    public final static String BRAND_ITEM_KEY_PREFIX = "brand:item:";

    public final static String BRAND_LIST_KEY = "brand:list";

    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    public BrandRedisRepositoryImpl() {
        log.debug("创建处理缓存的数据访问对象:BrandRedisRepositoryImpl");
    }

    private String getItemKey(Long id) {
        return BRAND_ITEM_KEY_PREFIX + id;
    }

    private String getListKey(){
        return BRAND_LIST_KEY;
    }

    @Override
    public void save(BrandStandardVO brandStandardVO) {
        log.debug("准备向Redis中写入brand数据,参数:{}", brandStandardVO);
        String key = getItemKey(brandStandardVO.getId());
        redisTemplate.opsForValue().set(key, brandStandardVO);
    }



    @Override
    public BrandStandardVO get(Long id) {
        log.debug("准备向Redis中读取brand数据,参数:{}", id);
        String key = getItemKey(id);
        Serializable serializable = redisTemplate.opsForValue().get(key);
        log.debug("读取完毕,准备返回对象,读取到的数据为{}", serializable);
        if (serializable != null) {
            if (serializable instanceof BrandStandardVO) {
                return (BrandStandardVO) serializable;
            }
        }
        return null;
    }

    @Override
    public void save(List<BrandListItemVO> brands) {
        String key = getListKey();
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        for (BrandListItemVO brand : brands) {
            ops.rightPush(key,brand);
        }
    }

    @Override
    public List<BrandListItemVO> list() {
        long start = 0;
        long end = -1;
        return list(start,end);
    }

    @Override
    public List<BrandListItemVO> list(long start, long end) {
        String key = getListKey();
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        List<Serializable> list = ops.range(key, start, end);
        List<BrandListItemVO> brands = new ArrayList<>();
        for (Serializable brand : list) {
            if(brand!=null){
                if (brand instanceof BrandListItemVO){
                    brands.add((BrandListItemVO) brand);
                }
            }

        }
        return brands;
    }
}
