package com.tedu.csmall.product.web;

/**
 * @author Meettry
 * @date 2022/9/28 14:47
 */
public enum ServiceCode {
    OK(200),
    ERR_NOT_FOUND(404),
    ERR_BAD_REQUEST(400),
    ERR(2);


    private Integer value;

    ServiceCode(Integer value) {
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
