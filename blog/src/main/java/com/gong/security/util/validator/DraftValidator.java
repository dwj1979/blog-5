package com.gong.security.util.validator;

import com.gong.security.exception.BaseException;
import com.gong.security.util.enums.ResultEnum;
import com.gong.security.vo.DraftVO;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by SNOW on 2018.01.30.
 */
public class DraftValidator {

    public static void validate(DraftVO draftVO) {
        if (null == draftVO
                || draftVO.getContentMd() == null) {
            throw new BaseException(ResultEnum.VALIDATE_ERROR);
        }
    }

    public static void validate(DraftVO draftVO,String errInfo) {
        if (null == draftVO
                || draftVO.getContentMd() == null) {
            throw new BaseException(ResultEnum.VALIDATE_ERROR.getCode(),errInfo);
        }
    }

    public static void draftExist(DraftVO draftVO) {
        validate(draftVO);
        if (StringUtils.isBlank(draftVO.getUserId())) {
            throw new BaseException(ResultEnum.VALIDATE_NOT_EXIST);
        }
    }

    public static void draftNotExist(DraftVO draftVO) {
        validate(draftVO);
        if (StringUtils.isNotBlank(draftVO.getUserId())) {
            throw new BaseException(ResultEnum.VALIDATE_NOT_EXIST);
        }
    }
}
