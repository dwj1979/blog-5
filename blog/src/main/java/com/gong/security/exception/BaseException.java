package com.gong.security.exception;

import com.gong.security.util.enums.ResultEnum;
import lombok.Data;

/**
 * Created by SNOW on 2018.01.18.
 */
@Data
public class BaseException extends RuntimeException{

    private Integer code;

    public BaseException(ResultEnum statusEnum){
        super(statusEnum.getMsg());
        this.code = statusEnum.getCode();
    }

    public BaseException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
}
