package com.tedu.csmall.product.exception;

/**
 * @author Meettry
 * @date 2022/9/26 16:00
 */
public class NameRepeatException extends RuntimeException{

    public NameRepeatException() {
        super();
    }

    public NameRepeatException(String message) {
        super(message);
    }

    public NameRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameRepeatException(Throwable cause) {
        super(cause);
    }

    protected NameRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
