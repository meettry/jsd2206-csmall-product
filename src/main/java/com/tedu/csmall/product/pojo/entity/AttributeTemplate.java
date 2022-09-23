package com.tedu.csmall.product.pojo.entity;

import lombok.Data;

/**
 * @author Meettry
 * @date 2022/9/22 15:20
 */
@Data
public class AttributeTemplate {
    private Long id;
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;

}
