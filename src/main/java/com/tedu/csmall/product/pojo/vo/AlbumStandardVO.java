package com.tedu.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 相册的标准VO类
 *
 * @author Meettry
 * @date 2022/9/23 9:03
 */
@Data
public class AlbumStandardVO implements Serializable {

    /**
     * 记录id
     */
    private Long id;

    /**
     * 相册名称
     */
    private String name;

    /**
     * 相册简介
     */
    private String description;

    /**
     * 自定义排序序号
     */
    private Integer sort;

}
