package com.tedu.csmall.product.mapper;

/**
 * @author Meettry
 * @date 2022/9/22 15:24
 */

import com.tedu.csmall.product.pojo.entity.AttributeTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@SpringBootTest
public class AttributeTemplateTest {
    @Autowired()
    private AttributeTemplateMapper mapper;


    @Test
    public void testInsert(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName("测试名称000");
        attributeTemplate.setPinyin("测试拼音000");
        attributeTemplate.setKeywords("测试关键词000");
        attributeTemplate.setSort(99);//取值必须是[0,255]
        log.trace("插入数据的参数为:"+attributeTemplate);
        int rows = mapper.insert(attributeTemplate);
        log.info("插入数据完成，受影响的行数=" + rows);
    }

    @Test
    public void testInsertBatch(){
        List<AttributeTemplate> list=new ArrayList<>();
        for (int i =0;i<=5;i++) {
            AttributeTemplate attributeTemplate = new AttributeTemplate();
            attributeTemplate.setName("测试名称000"+i);
            attributeTemplate.setPinyin("测试拼音000"+i);
            attributeTemplate.setKeywords("测试关键词000"+i);
            attributeTemplate.setSort(i);//取值必须是[0,255]
            list.add(attributeTemplate);
        }
        log.trace("插入数据的参数为:"+list);
        int rows = mapper.insertBatch(list);
        log.info("插入数据完成，受影响的行数="+rows);
    }


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
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setId(5L);
        attributeTemplate.setName("测试名称000"+7);
        attributeTemplate.setPinyin("测试拼音000"+7);
        attributeTemplate.setKeywords("测试关键词000"+7);
        attributeTemplate.setSort(7);
        int rows = mapper.updateById(attributeTemplate);
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

}
