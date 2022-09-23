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
    /*id*/
    private Long id;
    /*name*/
    private String name;
    /*description*/
    private String description;
    /*sort*/
    private Integer sort;

}
