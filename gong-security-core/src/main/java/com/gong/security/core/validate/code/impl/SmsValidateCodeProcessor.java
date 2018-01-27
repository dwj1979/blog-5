package com.gong.security.core.validate.code.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by SNOW on 2018.01.07.
 */
@Component
@Slf4j
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
    @Override
    public void send(ServletWebRequest request, ValidateCode validateCode) {
        log.debug("向"+request.getRequest().getParameter("mobile")+"发送验证码"+validateCode.getCode());
    }
}
