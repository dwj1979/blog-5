package com.gong.security.enums;

/**
 * Created by GongWenHua on 17.12.17.
 */
public class ExceptionStatusEnum implements IEnum<Integer> {

    private String message;
    private Integer index;

    @Override
    public Integer getCode() {
        return index;
    }

    @Override
    public String getMsg() {
        return message;
    }
}
