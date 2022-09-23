package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.Attribute;
import com.tedu.csmall.product.pojo.entity.Attribute;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/23 20:33
 */
@Slf4j
@SpringBootTest
public class AttributeTest {
    @Autowired
    private AttributeMapper mapper;

    @Test
    public void testInsert() {
        Attribute attribute = new Attribute();
        attribute.setName("测试名称0");
        attribute.setTemplateId(0L);
        attribute.setDescription("测试详情0");
        attribute.setSort(0);
        log.trace("插入数据的参数为:" + attribute);
        int rows = mapper.insert(attribute);
        log.info("插入数据完成，受影响的行数=" + rows);
    }
/*
    @Test
    public void testInsertBatch() {
        List<Attribute> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            Attribute attribute = new Attribute();
            attribute.setName("测试名称0" + i);
            attribute.setPinyin("测试拼音0" + i);
            attribute.setLogo("测试logo0" + i);
            attribute.setDescription("测试详情0" + i);
            attribute.setKeywords("测试关键词0" + i);
            attribute.setSort(0 + i);
            attribute.setSales(100 + i);
            attribute.setProductCount(100 + i);
            attribute.setCommentCount(100 + i);
            attribute.setPositiveCommentCount(100 + i);
            list.add(attribute);
        }
        log.trace("插入数据的参数为:" + list);
        int rows = mapper.insertBatch(list);
        log.info("插入数据完成，受影响的行数=" + rows);
    }


    @Test
    void testDeleteById() {
        int rows = mapper.deleteById(1L);
        log.info("删除成功,受影响行数" + rows);
    }

    @Test
    void testDeleteByIds() {
        Long[] array = {2L, 3L};
        int rows = mapper.deleteByIds(array);
        log.info("删除成功,受影响行数" + rows);
    }

    @Test
    void TestUpdateById() {
        Attribute attribute = new Attribute();
        attribute.setName("测试名称0" + 7);
        attribute.setPinyin("测试拼音0" + 7);
        attribute.setLogo("测试logo0" + 7);
        attribute.setDescription("测试详情0" + 7);
        attribute.setKeywords("测试关键词0" + 7);
        attribute.setSort(0 + 7);
        attribute.setSales(100 + 7);
        attribute.setProductCount(100 + 7);
        attribute.setCommentCount(100 + 7);
        attribute.setPositiveCommentCount(100 + 7);
        int rows = mapper.updateById(attribute);
        log.info("删除成功,受影响行数" + rows);
    }

    @Test
    void testCount() {
        int count = mapper.count();
        log.info("统计成功,该表共有" + count + "行");
    }

    @Test
    void testGetStandardById() {
        long id = 4L;
        //检验结果用Object
        Object result = mapper.getStandardById(id);
        log.trace("查询到的结果为" + result);
    }

    @Test
    void testList() {
        Object result = mapper.list();
        log.trace("查询到的结果为" + result);
    }

 */
}
