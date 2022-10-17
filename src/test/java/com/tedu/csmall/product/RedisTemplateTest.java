package com.tedu.csmall.product;

import com.tedu.csmall.product.pojo.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;

@Slf4j
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void set(){
        String key = "name";
        String value = "国斌老师";

        // 只要是对字符串类型的数据的value进行操作,必须调用opsForValue()得到相应的操作器
        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        ops.set(key,value);
        log.debug("已经向redis中写入Key为{}的数据:{}",key,value);
    }

    @Test
    public void getValue(){
        String key = "name";
        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经向redis中取出Key为{}的数据:{}",key,value);
    }
    @Test
    public void setObjectValue(){
        String key = "brand1";
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setName("测试品牌");
        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        ops.set(key,brand);
        log.debug("已经向redis中取出Key为{}的数据:{}",key,brand);
    }

    @Test
    public void getObjectValue(){
        String key = "brand1";
        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经向redis中取出Key为{}的数据:{}",key,value);
    }

    @Test
    public void getNull(){
        String key = "brand112312421412";
        ValueOperations<String,Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经向redis中取出Key为{}的数据:{}",key,value);
    }

    @Test
    public void getKeys(){
        String keyPattern = "*";
        Set<String> keys = redisTemplate.keys(keyPattern);
        for (String key : keys) {
            log.debug("key={}",key);
        }
    }
}
