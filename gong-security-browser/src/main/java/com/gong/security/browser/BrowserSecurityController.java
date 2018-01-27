package com.gong.security.browser;

import com.gong.security.browser.support.SimpleResponse;
import com.gong.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 为什么会有这个Controller 直接写signIn.html不好吗，为社么要写/auth/require。
 * 答：我们要对请求类型进行区分，html的请求返回登陆页，其他请求则返回json内容。
 * Created by GongWenHua on 17.12.26.
 */
@RestController
@Slf4j
public class BrowserSecurityController {

    // 可以通过重定向过的请求获取到重定向之前的缓存请求
    private RequestCache requestCache = new HttpSessionRequestCache();
    //
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    // 配置
    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 当需要身份认证时，跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/auth/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)// 针对普通restful请求。
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(null != savedRequest){
            String target = savedRequest.getRedirectUrl();
            log.info("原始请求URL:{}",target);
            if(StringUtils.endsWithIgnoreCase(target,".html")){
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getSignInPage());
            }
        }
        return  new SimpleResponse("请求未授权，请登陆");
    }
}
