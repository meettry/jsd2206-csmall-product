package com.tedu.csmall.product.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author  Meettry
 * @date  2022/9/22 11:26
 */
@Data
public class Album {
    /*id*/
    private Long id ;
    /*name*/
    private String name;
    /*description*/
    private String description;
    /*sort*/
    private Integer sort;
    /*gmt_create*/
    private LocalDateTime getCreate;
    /*gmt_modified*/
    private LocalDateTime gmtModified;
}
