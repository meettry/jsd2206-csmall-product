package com.tedu.csmall.product;

import com.tedu.csmall.product.pojo.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void set() {
        String key = "name";
        String value = "国斌老师";

        // 只要是对字符串类型的数据的value进行操作,必须调用opsForValue()得到相应的操作器
        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        ops.set(key, value);
        log.debug("已经向redis中写入Key为{}的数据:{}", key, value);
    }

    @Test
    public void getValue() {
        String key = "name";
        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经向redis中取出Key为{}的数据:{}", key, value);
    }

    @Test
    public void setObjectValue() {
        String key = "brand1";
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setName("测试品牌");
        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        ops.set(key, brand);
        log.debug("已经向redis中取出Key为{}的数据:{}", key, brand);
    }

    @Test
    public void getObjectValue() {
        String key = "brand1";
        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经向redis中取出Key为{}的数据:{}", key, value);
    }

    @Test
    public void getNull() {
        String key = "brand112312421412";
        ValueOperations<String, Serializable> ops = redisTemplate.opsForValue();
        Serializable value = ops.get(key);
        log.debug("已经向redis中取出Key为{}的数据:{}", key, value);
    }

    @Test
    public void getKeys() {
        String keyPattern = "*";
        Set<String> keys = redisTemplate.keys(keyPattern);
        for (String key : keys) {
            log.debug("key={}", key);
        }
        log.debug("keys={}", keys);
    }

    @Test
    public void delete() {
        String key = "name";
        Boolean result = redisTemplate.delete(key);
        log.debug("删除key为{}的值,结果为{}", key, result);

    }

    @Test
    void deleteAll() {
        String setPattern = "*";
        Set<String> keys = redisTemplate.keys(setPattern);
        Long result = redisTemplate.delete(keys);
        log.debug("删除全部数据,受影响的行数为{}", result);
    }

    // 存List集合
    @Test
    void setList(){

        List<Brand> brands = new ArrayList<>();
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        String key = "brands";
        for (int i =0;i<5;i++){
            Brand brand = new Brand();
            brand.setId((long) i);
            brand.setName("测试品牌"+i);
            brands.add(brand);
        }

        for (Brand brand : brands) {
            ops.rightPush(key,brand);
        }
        log.debug("向redis中写入key为{}的数据,写入的列表为{}",key
        ,brands);
    }

    @Test
    void listSize(){
        String key = "brands";
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        Long size = ops.size(key);
        log.debug("在redis中Key为{}的列表的长度为{}",key,size);
    }

    @Test
    void listRange(){
        //list的正向下标--从左到右 0->size()-1
        //反向下标--从右到左  -1->-size()
        //获取集合全部数据 start=0 end=-1
        String key = "brands";
        long start = 0;
        long end = 100;
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        List<Serializable> list = ops.range(key, start, end);
        log.debug("在redis中Key为{}的列表,start为{},end为{},获取到的列表长度为{}",key,start,end,list.size());
        for (Serializable brand : list) {
            log.debug("brand={}",brand);
        }
         start = 0;
         end = -5;
        list = ops.range(key, start, end);
        log.debug("在redis中Key为{}的列表,start为{},end为{},获取到的列表长度为{}",key,start,end,list.size());
        for (Serializable brand : list) {
            log.debug("brand={}",brand);
        }


    }
}
