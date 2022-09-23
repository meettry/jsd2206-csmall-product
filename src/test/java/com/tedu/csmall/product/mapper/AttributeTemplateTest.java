package com.tedu.csmall.product.mapper;

/**
 * @author Meettry
 * @date 2022/9/22 15:24
 */

import com.tedu.csmall.product.mapper.AttributeTemplateMapper;
import com.tedu.csmall.product.pojo.entity.AttributeTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AttributeTemplateTest {
    @Autowired
    private AttributeTemplateMapper attributeTemplateMapper;

    @Test
    void testAttributeTemplateMapper(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName("测试001");
        int row = attributeTemplateMapper.insert(attributeTemplate);
        System.out.println("测试成功");
    }
}
