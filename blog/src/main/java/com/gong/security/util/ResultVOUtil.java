package com.gong.security.util;

import com.gong.security.util.enums.ResultEnum;
import com.gong.security.exception.BaseException;
import com.gong.security.vo.ResultVO;
import org.springframework.data.domain.Page;

/**
 * Created by SNOW on 2018.01.18.
 */
public class ResultVOUtil {
    private ResultVOUtil() {
    }

    public static ResultVO success(Object data) {
        return new ResultVO(0, "success", data, null);
    }

    public static ResultVO page(Page page) {
        return new ResultVO(0, "success", page.getContent(), PageUtil.GetPaginationFrom(page));
    }

    public static ResultVO success() {
        return new ResultVO(0, "success", null, null);
    }

    public static ResultVO error(BaseException exception) {
        return new ResultVO(exception.getCode(), exception.getMessage(), null, null);
    }

    public static ResultVO error(ResultEnum exceptionStatusEnum) {
        return new ResultVO(exceptionStatusEnum.getCode(), exceptionStatusEnum.getMsg(), null, null);
    }

    public static ResultVO error(int code, String message) {
        return new ResultVO(code, message, null, null);
    }

}
