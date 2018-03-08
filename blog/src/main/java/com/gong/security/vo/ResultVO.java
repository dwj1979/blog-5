package com.gong.security.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by SNOW on 2018.01.18.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable
{
    private static final long serialVersionUID = 5216059160426137256L;
    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 具体内容 */
    private T data;

    /** 分页信息 **/
    private Pagination pagination;

    public ResultVO(){
    }

    public ResultVO(Integer code,String message,T data,Pagination pagination){
        this.code = code;
        this.message = message;
        this.data = data;
        this.pagination = pagination;
    }
}
