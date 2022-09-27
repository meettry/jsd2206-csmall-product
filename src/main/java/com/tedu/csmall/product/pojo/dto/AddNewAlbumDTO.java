package com.tedu.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 添加相册的DTO类
 *
 * @author Meettry
 * @date 2022/9/26 15:21
 */
@Data
public class AddNewAlbumDTO implements Serializable {
    private String name;
    private String description;
    private int sort;
}
