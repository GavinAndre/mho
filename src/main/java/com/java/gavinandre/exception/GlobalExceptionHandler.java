package com.java.gavinandre.exception;

import com.java.gavinandre.pojo.ResponseWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gavinandre on 17-1-22.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ResponseWrapper handle(CustomException ex) {
        String message = ex.getMessage();
        return ex.getErrorWrapper(0, message);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseWrapper handle(Exception ex) {
        String message = ex.getMessage();
        System.out.println("GlobalExceptionHandler: " + message);
        return ResponseWrapper.occurException(0, message);
    }

}
