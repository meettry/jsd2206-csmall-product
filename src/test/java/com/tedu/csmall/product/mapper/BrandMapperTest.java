package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/23 10:24
 */
@Slf4j
@SpringBootTest
public class BrandMapperTest {
    @Autowired
    private BrandMapper mapper;
    @Test
    public void testInsert(){
        Brand Brand = new Brand();
        Brand.setName("测试相册000");
        Brand.setDescription("测试简介000");
        Brand.setSort(99);//取值必须是[0,255]
        log.trace("插入数据的参数为:"+Brand);
        int rows = mapper.insert(Brand);
        log.info("插入数据完成，受影响的行数=" + rows);
    }

    @Test
    public void testInsertBatch(){
        List<Brand> list=new ArrayList<>();
        for (int i =0;i<=5;i++) {
            Brand Brand = new Brand();
            Brand.setName("测试"+i);
            Brand.setDescription("测试简介"+i);
            Brand.setSort(i);//取值必须是[0,255]
            list.add(Brand);
        }
        log.trace("插入数据的参数为:"+list);
        int rows = mapper.insertBatch(list);
        log.info("插入数据完成，受影响的行数="+rows);
    }

/*
    @Test
    void testDeleteById(){
        int rows = mapper.deleteById(1L);
        log.info("删除成功,受影响行数"+rows);
    }

    @Test
    void testDeleteByIds(){
        Long[] array = {2L,3L};
        int rows = mapper.deleteByIds(array);
        log.info("删除成功,受影响行数"+rows);
    }

    @Test
    void TestUpdateById(){
        Brand Brand = new Brand();
        Brand.setId(5L);
        Brand.setName("很新的相册名称");
        Brand.setDescription("很新的相册简");
        Brand.setSort(199);
        int rows = mapper.updateById(Brand);
        log.info("删除成功,受影响行数"+rows);
    }

    @Test
    void testCount(){
        int count = mapper.count();
        log.info("统计成功,该表共有"+count+"行");

    }

    @Test
    void testGetStandardById(){
        long id=4L;
        //检验结果用Object
        Object result =  mapper.getStandardById(id);
        log.trace("查询到的结果为"+result);
    }

    @Test
    void testList(){
        Object result = mapper.list();
        log.trace("查询到的结果为"+result);
    }

 */
}
