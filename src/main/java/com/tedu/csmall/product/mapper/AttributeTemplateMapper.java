package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.AttributeTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Meettry
 * @date 2022/9/22 15:23
 */
@Repository
public interface AttributeTemplateMapper {
    int insert(AttributeTemplate attributeTemplate);
}