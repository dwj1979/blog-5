package com.gong.security.util.validator;

import com.gong.security.exception.BaseException;
import com.gong.security.util.enums.ResultEnum;

/**
 * Created by SNOW on 2018.02.01.
 */
public class CommonValidator {

    public static void getOk(Object entity) {
        if (null == entity) {
            throw new BaseException(ResultEnum.GET_ERROR);
        }
    }

    public static void saveOk(Object entity) {
        if (null == entity) {
            throw new BaseException(ResultEnum.SAVE_ERROR);
        }
    }

    public static void delOk(Object entity) {
        if (null == entity) {
            throw new BaseException(ResultEnum.DEL_ERROR);
        }
    }
}
