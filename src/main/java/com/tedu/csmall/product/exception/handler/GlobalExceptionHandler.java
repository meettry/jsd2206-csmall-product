package com.tedu.csmall.product.exception.handler;

import com.tedu.csmall.product.exception.ServiceException;
import com.tedu.csmall.product.web.JsonResult;
import com.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public JsonResult handleServiceException(ServiceException e) {
        log.debug("捕获到ServiceException：{}", e.getMessage());
        return JsonResult.fail(e.getServiceCode(),e.getMessage());
    }

    @ExceptionHandler
    public String handleNullPointerException(NullPointerException e) {
        log.debug("捕获到NullPointerException：{}", e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler
    public String handleRuntimeException(RuntimeException e) {
        log.debug("捕获到RuntimeException：{}", e.getMessage());
        return e.getMessage();
    }


    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        log.debug("捕获到Throwable：{}", e.getMessage());
        e.printStackTrace(); // 强烈建议
        return "服务器运行过程中出现未知错误,请联系系统管理员";
    }





}
