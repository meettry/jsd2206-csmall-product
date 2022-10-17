package com.tedu.csmall.product.exception.handler;

import com.tedu.csmall.product.exception.ServiceException;
import com.tedu.csmall.product.web.JsonResult;
import com.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult handleServiceException(ServiceException e) {
        log.debug("捕获到ServiceException：{}", e.getMessage());
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult BindException(BindException e){
        log.debug("捕获到ServiceException：{}", e.getMessage());
        StringBuilder stringBuilder = new StringBuilder();
        //获取全部错误
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String defaultMessage = fieldError.getDefaultMessage();
            stringBuilder.append(defaultMessage);
        }
        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST,stringBuilder.toString());
    }

    @ExceptionHandler
    public String handleNullPointerException(NullPointerException e) {
        log.debug("捕获到NullPointerException：{}", e.getMessage());
        return e.getMessage();
    }


    @ExceptionHandler
    public JsonResult handleAccessDeniedException(AccessDeniedException e){
        log.debug("捕获到DisabledException：{}", e.getMessage());
        String message = "请求失败,当前登录的账号不哭被此操作权限！";
        return JsonResult.fail(ServiceCode.ERR, message);
    }

    @ExceptionHandler
    public String handleThrowable(Throwable e) {
        log.debug("捕获到Throwable：{}", e.getMessage());
        e.printStackTrace(); // 强烈建议
        return "服务器运行过程中出现未知错误,请联系系统管理员";
    }





}
