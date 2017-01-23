package com.java.gavinandre.exception;

import com.java.gavinandre.pojo.ResponseWrapper;

/**
 * Created by gavinandre on 17-1-19.
 */
public class CustomException extends Exception {

    //异常信息
    private String message;
    private Integer code;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public ResponseWrapper getErrorWrapper(Integer code, String message) {
        return ResponseWrapper.occurException(code, message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
