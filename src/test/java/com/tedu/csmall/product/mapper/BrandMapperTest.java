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
    public void testInsert() {
        Brand brand = new Brand();
        brand.setName("测试名称0");
        brand.setPinyin("测试拼音0");
        brand.setLogo("测试logo0");
        brand.setDescription("测试详情0");
        brand.setKeywords("测试关键词0");
        brand.setSort(0);
        brand.setSales(100);
        brand.setProductCount(100);
        brand.setCommentCount(100);
        brand.setPositiveCommentCount(100);
        log.trace("插入数据的参数为:" + brand);
        int rows = mapper.insert(brand);
        log.info("插入数据完成，受影响的行数=" + rows);
    }

    @Test
    public void testInsertBatch() {
        List<Brand> list = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            Brand brand = new Brand();
            brand.setName("测试名称0" + i);
            brand.setPinyin("测试拼音0" + i);
            brand.setLogo("测试logo0" + i);
            brand.setDescription("测试详情0" + i);
            brand.setKeywords("测试关键词0" + i);
            brand.setSort(0 + i);
            brand.setSales(100 + i);
            brand.setProductCount(100 + i);
            brand.setCommentCount(100 + i);
            brand.setPositiveCommentCount(100 + i);
            list.add(brand);
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
        Brand brand = new Brand();
        brand.setName("测试名称0" + 7);
        brand.setPinyin("测试拼音0" + 7);
        brand.setLogo("测试logo0" + 7);
        brand.setDescription("测试详情0" + 7);
        brand.setKeywords("测试关键词0" + 7);
        brand.setSort(0 + 7);
        brand.setSales(100 + 7);
        brand.setProductCount(100 + 7);
        brand.setCommentCount(100 + 7);
        brand.setPositiveCommentCount(100 + 7);
        int rows = mapper.updateById(brand);
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

}
