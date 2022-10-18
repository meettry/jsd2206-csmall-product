package com.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 添加品牌的DTO类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Data
public class AddNewBrandDTO implements Serializable {

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称", required = true)
    @NotNull(message = "添加品牌失败！必须提交品牌名称！")
    private String name;

    /**
     * 品牌名称的拼音
     */
    @ApiModelProperty(value = "品牌名称的拼音", required = true)
    @NotNull(message = "添加品牌失败！必须提交品牌名称的拼音！")
    private String pinyin;

    /**
     * 品牌logo的URL
     */
    @ApiModelProperty("品牌logo的URL")
    private String logo;

    /**
     * 品牌简介
     */
    @ApiModelProperty("品牌简介")
    private String description;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @ApiModelProperty("关键词列表，各关键词使用英文的逗号分隔")
    private String keywords;

    /**
     * 自定义排序序号
     */
    @ApiModelProperty(value = "自定义排序序号", required = true)
    private Integer sort;

    /**
     * 是否启用，1=启用，0=未启用
     */
    @ApiModelProperty(value = "是否启用，1=启用，0=未启用", example = "1", required = true)
    private Integer enable;

}
