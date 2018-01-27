package com.gong.security.core.validate.code.impl;

import com.gong.security.core.validate.code.ValidateCodeGenerator;
import com.gong.security.core.validate.code.ValidateCodeProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by SNOW on 2018.01.07.
 */
@Slf4j
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    @Autowired
    private Map<String,ValidateCodeGenerator> validateCodeGenerators;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void create(ServletWebRequest request) throws IOException {
        C validateCode = generate(request);
        log.debug("生成验证码{}",validateCode.getCode());
        save(request,validateCode);
        send(request,validateCode);
    }

    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getValidateType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(type + "ValidateCodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     *
     * @param request
     * @return
     */
    private String getValidateType(ServletWebRequest request){
        return StringUtils.substringAfter(request.getRequest().getRequestURI(),"code/");
    }

    /**
     * 保存validateCode到session中
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request,C validateCode){
        sessionStrategy.setAttribute(request, SESSION_KEY, validateCode);
    }

    /**
     * 发送validateCode
     * @param request
     * @param validateCode
     * @throws IOException
     */
    public abstract void send(ServletWebRequest request,C validateCode) throws IOException;


}
