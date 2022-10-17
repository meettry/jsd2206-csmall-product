package com.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Meettry
 * @date 2022/9/22 16:07
 */
@Data
public class Attribute  implements Serializable {
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
     * 输入类型，0=手动录入，1=单选，2=多选，3=单选（下拉列表），4=多选（下拉列表）
     */
    private Integer inputType;
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
    private String util;

    /**
     * 是否允许自定义，1=允许，0=禁止
     */
    private Integer isAllowCustomize;

    /**
     * 数据创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 数据最后修改时间
     */
    private LocalDateTime gmtModified;
}
