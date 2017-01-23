package com.java.gavinandre.pojo;

import java.io.Serializable;

/**
 * Created by gavinandre on 17-1-12.
 */
public class ResponseWrapper<T> implements Serializable {

    private Integer code = 1;

    private String errorMsg = "成功";

    private T requestData;

    public ResponseWrapper() {
    }

    private ResponseWrapper(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public static ResponseWrapper occurException(Integer code, String errorMsg) {
        return new ResponseWrapper(code, errorMsg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }
}
