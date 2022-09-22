package com.tedu.csmall.product.pojo.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album implements Serializable {
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
