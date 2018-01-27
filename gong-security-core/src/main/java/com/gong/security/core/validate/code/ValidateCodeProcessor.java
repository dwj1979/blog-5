package com.gong.security.core.validate.code;

import com.gong.security.core.validate.code.impl.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * Created by SNOW on 2018.01.07.
 */
public interface ValidateCodeProcessor {
    String SESSION_KEY = "SESSION_KEY_FOR_CODE";
    void create(ServletWebRequest request) throws IOException;
}
