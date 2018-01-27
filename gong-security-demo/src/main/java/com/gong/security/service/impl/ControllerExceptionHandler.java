package com.gong.security.service.impl;

import com.gong.security.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GongWenHua on 17.12.17.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Map<String, Object> handleBaseException(BaseException baseException) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", baseException.getCode());
        result.put("message", baseException.getMessage());
        return result;
    }
}
