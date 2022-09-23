package com.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Meettry
 * @date 2022/9/23 20:30
 */
@Data
public class AttributeListItemVO implements Serializable {
    /**
     * 记录id
     */
    private Long id;

    /**
     * 属性模板名称
     */
    private String name;

    /**
     * 所属属性模板id
     */
    private Long templateId;

    /**
     * 相册简介
     */
    private String description;

    /**
     * 自定义排序序号
     */
    private Integer sort;

    /**
     * 属性类型，1=销售属性，0=非销售属性
     */
    private Integer type;

    /**
     * 备选值列表
     */
    private String valueList;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 是否允许自定义，1=允许，0=禁止
     */
    private Integer isAllowCustomize;
}
