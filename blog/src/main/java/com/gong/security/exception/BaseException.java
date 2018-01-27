package com.gong.security.exception;

import com.gong.security.enums.ExceptionStatusEnum;
import lombok.Data;

/**
 * Created by SNOW on 2018.01.18.
 */
@Data
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
}
