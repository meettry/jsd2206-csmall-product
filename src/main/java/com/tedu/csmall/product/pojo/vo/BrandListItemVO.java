package com.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Meettry
 * @date 2022/9/23 19:26
 */
@Data
public class BrandListItemVO implements Serializable {
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
}
