package com.gong.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gong.security.core.properties.LoginType;
import com.gong.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认的spring boot Authentication 成功的处理方式是调换到之前的请求，
 * 但是我们不想在SPA单页应用中的AJAX请求登陆方式被跳转。所以我们可能希望返回认证信息。
 * 所以在浏览器中根据配置的认证方式，可以设置返回的内容为JSON还是跳转。
 * Created by SNOW on 17.12.27.
 */
@Component
@Slf4j
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登陆成功");
        if (securityProperties.getBrowser().getLoginType().equals(LoginType.JSON)) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            // 默认的处理器是跳转到之前的请求
            super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);
        }
    }
}
