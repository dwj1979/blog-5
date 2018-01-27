package com.gong.security.core.validate.code.impl;

import com.gong.security.core.properties.SecurityProperties;
import com.gong.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by SNOW on 2018.01.07.
 */
@Component
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        return new ValidateCode(UUID.randomUUID().toString().substring(0,securityProperties.getValidateCode().getSmsCode().getLength()),60);
    }
}
