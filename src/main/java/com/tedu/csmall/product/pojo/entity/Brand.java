package com.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Meettry
 * @date 2022/9/23 9:47
 */
@Data
public class Brand {

    /**
     * 记录id
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌简介
     */
    private String description;

    /**
     * 品牌名称的拼音
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

    /**
     * 品牌logo的url
     */
    private String logo;

    /**
     * 销量(冗余)
     */
    private Integer sales;

    /**
     * 商品种类数量的总和(冗余)
     */
    private Integer productCount;

    /**
     * 买家评论数量的总和(冗余)
     */
    private Integer commentCount;

    /**
     * 买家好评数量的总和(冗余)
     */
    private Integer positiveCommentCount;

    /**
     * 是否启用,1=启用,0=未启用
     */
    private Integer enable;

    /**
     * 数据创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 数据最后修改时间
     */
    private LocalDateTime gmtModified;
}
