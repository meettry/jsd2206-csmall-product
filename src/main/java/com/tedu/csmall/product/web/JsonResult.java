package com.tedu.csmall.product.web;

import com.tedu.csmall.product.exception.ServiceException;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Meettry
 * @date 2022/9/28 11:36
 */
@Data
public class JsonResult<T> implements Serializable {
    /**
     * 状态
     */
    private Integer state;

    /**
     * 操作失败时的提示文本
     */
    private String message;

    /**
     * 操作成功时返回的数据
     */
    private T data;

    public static JsonResult ok() {
        return JsonResult.ok(null);
    }

    public static JsonResult ok(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = ServiceCode.OK.getValue();
        jsonResult.data = data;
        return jsonResult;
    }

    public static JsonResult fail(ServiceException e){
        return JsonResult.fail(e.getServiceCode(),e.getMessage());
    }

    public static JsonResult fail(ServiceCode serviceCode, String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = serviceCode.getValue();
        jsonResult.message = message;
        return jsonResult;
    }
}
