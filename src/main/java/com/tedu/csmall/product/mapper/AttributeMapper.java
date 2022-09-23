package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.Attribute;
import org.springframework.stereotype.Repository;

/**
 * @author Meettry
 * @date 2022/9/22 16:07
 */
@Repository
public interface AttributeMapper {
    int insert(Attribute attribute);
}
