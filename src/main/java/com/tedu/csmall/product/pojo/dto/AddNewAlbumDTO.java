package com.tedu.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 添加相册的DTO类
 *
 * @author Meettry
 * @date 2022/9/26 15:21
 */
@Data
public class AddNewAlbumDTO implements Serializable {
    @NotNull(message = "添加失败,必须提交相册名称")
    @ApiModelProperty(value = "相册名称")
    private String name;


    @ApiModelProperty(value = "相册简介")
    private String description;

    @Range(max = 255, message = "添加相册失败,排序序号必须在[0,255]之间")
    @ApiModelProperty(value = "排序序号")
    private int sort;
}
