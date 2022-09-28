package com.tedu.csmall.product.exception;

import com.tedu.csmall.product.web.ServiceCode;

/**
 * @author Meettry
 * @date 2022/9/26 16:00
 */
public class ServiceException extends RuntimeException{
    private ServiceCode serviceCode;

    public ServiceException() {
        super();
    }

    public ServiceException(ServiceCode serviceCode,String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }
}
