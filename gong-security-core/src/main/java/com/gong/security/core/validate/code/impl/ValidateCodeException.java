package com.gong.security.core.validate.code.impl;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by SNOW on 18.1.2.
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -8301449984089317593L;

    public ValidateCodeException(String msg){
        super(msg);
    }
}
