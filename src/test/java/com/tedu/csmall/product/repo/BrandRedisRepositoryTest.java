package com.tedu.csmall.product.repo;

import com.tedu.csmall.product.pojo.entity.Brand;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class BrandRedisRepositoryTest {
    @Autowired
    BrandRedisRepository brandRedisRepository;
    @Test
    public void testSave(){
        BrandStandardVO brandStandardVO = new BrandStandardVO();
        brandStandardVO.setId(50L);
        brandStandardVO.setName("测试Name");
        brandRedisRepository.save(brandStandardVO);
        log.debug("测试成功");
    }

    @Test
    public void testGet(){
        BrandStandardVO brandStandardVO = brandRedisRepository.get(500L);
        log.debug("测试成功,成功取出数据{}",brandStandardVO);
    }

    @Test
    void setList(){

        List<BrandListItemVO> brands = new ArrayList<>();

        String key = "brands";
        for (int i =0;i<5;i++){
            BrandListItemVO brand = new BrandListItemVO();
            brand.setId((long) i);
            brand.setName("测试品牌"+i);
            brands.add(brand);
        }

        brandRedisRepository.save(brands);
        log.debug("向redis中写入key为{}的数据,写入的列表为{}",key
                ,brands);
    }

    @Test
    void testListRange(){
        //list的正向下标--从左到右 0->size()-1
        //反向下标--从右到左  -1->-size()
        //获取集合全部数据 start=0 end=-1
        String key = "brands";
        long start = 0;
        long end = 1;
        List<BrandListItemVO> list = brandRedisRepository.list(start, end);
        log.debug("在redis中Key为{}的列表,start为{},end为{},获取到的列表长度为{}",key,start,end,list.size());
        for (Serializable brand : list) {
            log.debug("brand={}",brand);
        }
        start = 0;
        end = -5;
        list = brandRedisRepository.list(start, end);
        log.debug("在redis中Key为{}的列表,start为{},end为{},获取到的列表长度为{}",key,start,end,list.size());
        for (Serializable brand : list) {
            log.debug("brand={}",brand);
        }
        log.debug("list集合:{}",brandRedisRepository.list());


    }
}

