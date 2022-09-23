package com.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Meettry
 * @date 2022/9/23 18:49
 */
@Data
public class AttributeTemplateListItemVO implements Serializable {
    /**
     * 记录id
     */
    private Long id;

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
