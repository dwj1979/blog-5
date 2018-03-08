package com.gong.security.exception.handler;

import com.gong.security.util.enums.ResultEnum;
import com.gong.security.exception.BaseException;
import com.gong.security.util.ResultVOUtil;
import com.gong.security.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 拦截异常
 * Created by GongWenHua on 2017/8/4.
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    //      200：请求成功
    //      201：创建、修改成功
    //      204：删除成功
    //      400：参数错误
    //      401：未登录
    //      403：禁止访问
    //      404：未找到
    //      500：系统错误

    /**
     * 处理SellException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handleSellException(BaseException e) {
        log.error("【异常】【{}】【{}】", e.getMessage(), e);
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数匹配异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO handleSellException(MissingServletRequestParameterException e) {
        log.error("【异常】【{}】【{}】", e.getMessage(), e);
        return ResultVOUtil.error(ResultEnum.REQUEST_MISMATCH_ERROR.getCode(), ResultEnum.REQUEST_MISMATCH_ERROR.getMsg());
    }
}
