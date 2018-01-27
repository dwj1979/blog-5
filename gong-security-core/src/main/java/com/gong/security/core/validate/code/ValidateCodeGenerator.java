package com.gong.security.core.validate.code;

import com.gong.security.core.validate.code.impl.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SNOW on 2018.01.04.
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
