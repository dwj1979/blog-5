package com.gong.security.core.validate.code.impl;

import com.gong.security.core.properties.SecurityProperties;
import com.gong.security.core.validate.code.ValidateCodeProcessor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SNOW on 18.1.2.
 */
@Slf4j
@Data
@Component
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    private Set<String> urlSet = new HashSet<>();

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        log.debug("ValidateCodeFilter Bean afterPropertiesSet , securityProperties = {}", securityProperties);
        String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getValidateCode().getImgCode().getUrls(), ";");
        for (String url : urls) {
            urlSet.add(url);
        }
        urlSet.add("/auth/form");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;
        for (String url : urlSet) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                action = true;
            }
        }

        if (action) {
            try {
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {

        ImgCode imgCodeInSession = (ImgCode) sessionStrategy.getAttribute(servletWebRequest, ValidateCodeProcessor.SESSION_KEY);
        if (null == imgCodeInSession) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        String imgCodeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "imgCode");

        if (StringUtils.isBlank(imgCodeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (StringUtils.isBlank(imgCodeInSession.getCode())) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (imgCodeInSession.isExpired()) {
            throw new ValidateCodeException("验证码已过期");
        }


        if (!StringUtils.equalsIgnoreCase(imgCodeInRequest, imgCodeInSession.getCode())) {
            throw new ValidateCodeException("验证码不匹配");
        }
        log.debug("图片验证通过:{}<=>{}", imgCodeInRequest, imgCodeInSession.getCode());
        sessionStrategy.removeAttribute(servletWebRequest, ValidateCodeProcessor.SESSION_KEY);

    }
}
