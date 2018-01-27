package com.gong.security.exception;

import com.gong.security.enums.ExceptionStatusEnum;

/**
 * Created by GongWenHua on 17.12.17.
 */
public class BaseException extends RuntimeException{

    private Integer code;

    public BaseException(ExceptionStatusEnum statusEnum){
        super(statusEnum.getMsg());
        this.code = statusEnum.getCode();
    }

    public BaseException(String msg,Integer code){
        super(msg);
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
}
