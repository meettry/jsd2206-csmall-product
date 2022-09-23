package com.tedu.csmall.product.pojo.entity;

import lombok.Data;

/**
 * @author Meettry
 * @date 2022/9/22 16:07
 */
@Data
public class Attribute {
    private Long id;
    private Long templateId;
    private String name;
    private String description;
    private Integer type;
    private String valueList;
    private String unit;
    private Integer sort;
    private Integer isAllowCustomize;
}
