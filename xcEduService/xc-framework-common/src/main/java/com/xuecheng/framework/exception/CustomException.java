package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author: Yizq
 * @data: 2020/4/18 21:16
 * @deprecated 异常处理类
 */

public class CustomException extends RuntimeException {
    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

}
