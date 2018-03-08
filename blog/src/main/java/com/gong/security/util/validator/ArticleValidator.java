package com.gong.security.util.validator;

import com.gong.security.exception.BaseException;
import com.gong.security.util.enums.ResultEnum;
import com.gong.security.vo.ArticleVO;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by SNOW on 2018.01.30.
 */
public class ArticleValidator {

    public static void validate(ArticleVO articleVO) {
        if (null == articleVO
                || StringUtils.isBlank(articleVO.getUserId())
                || StringUtils.isBlank(articleVO.getContentMd())
                || StringUtils.isBlank(articleVO.getContentHtml())
                || StringUtils.isBlank(articleVO.getContentText())) {
            throw new BaseException(ResultEnum.VALIDATE_ERROR);
        }
    }

    public static void articleExist(ArticleVO articleVO) {
        validate(articleVO);
        if (StringUtils.isBlank(articleVO.getArticleId())) {
            throw new BaseException(ResultEnum.VALIDATE_NOT_EXIST);
        }
    }

    public static void articleNotExist(ArticleVO articleVO) {
        validate(articleVO);
        if (StringUtils.isBlank(articleVO.getArticleId())) {
            throw new BaseException(ResultEnum.VALIDATE_NOT_EXIST);
        }
    }

}
