package com.gong.security.util;

import com.gong.security.enums.ExceptionStatusEnum;
import com.gong.security.exception.BaseException;
import com.gong.security.vo.ResultVO;

/**
 * Created by SNOW on 2018.01.18.
 */
public class ResultVOUtil {
    private ResultVOUtil() {
    }

    public static ResultVO success(Object data) {
        return new ResultVO(0, "success", data);
    }

    public static ResultVO success() {
        return new ResultVO(0, "success", null);
    }

    public static ResultVO error(BaseException exception) {
        return new ResultVO(exception.getCode(), exception.getMessage(), null);
    }

    public static ResultVO error(ExceptionStatusEnum exceptionStatusEnum) {
        return new ResultVO(exceptionStatusEnum.getCode(), exceptionStatusEnum.getMsg(), null);
    }

    public static ResultVO error(int code, String message) {
        return new ResultVO(code, message, null);
    }

}
