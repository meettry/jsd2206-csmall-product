package com.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Meettry
 * @date 2022/9/28 19:21
 */
@Data
public class AddNewAttributeTemplateDTO implements Serializable {
    /**
     * 属性模板名称
     */
    private String name;

    /**
     * 属性模板名称的拼音
     */
    private String pinyin;

    /**
     * 关键词列表
     */
    private String keywords;

    /**
     * 自定义排序序号
     */
    private Integer sort;
}
