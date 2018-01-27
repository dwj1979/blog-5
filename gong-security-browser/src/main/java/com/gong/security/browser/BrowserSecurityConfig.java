package com.gong.security.browser;

import com.gong.security.browser.authentication.MyAuthenticationFailureHandler;
import com.gong.security.browser.authentication.MyAuthenticationSuccessHandler;
import com.gong.security.core.properties.SecurityProperties;
import com.gong.security.core.validate.code.impl.ValidateCodeFilter;
import com.gong.security.core.validate.code.impl.ValidateCodeGeneratorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by GongWenHua on 17.12.25.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private ValidateCodeGeneratorConfig validateCodeGeneratorConfig;

    @Autowired
    private SpringSocialConfigurer springSocialConfigurer;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // 如果时html请求，返回一个html页面，如果是单纯restful请求，返回json信息。
    // 通过/auto/require判断。
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        http.
//                apply(springSocialConfigurer).
//                    and().
//                addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class).// 添加自定义过滤器
//                formLogin().
//                loginPage("/auth/require").
//                loginProcessingUrl("/auth/form").
//                successHandler(authenticationSuccessHandler). // 处理登陆路径
//                failureHandler(authenticationFailureHandler).
//
//                and().authorizeRequests().
//                antMatchers("/auth/*",
//                        "/code/*",
//                        securityProperties.getBrowser().getSignInPage()).
//                permitAll().
//                anyRequest().authenticated().      // 这些路径不需要授权

//                and().
        authorizeRequests().
                antMatchers(HttpMethod.OPTIONS).permitAll().
                and().
                csrf().disable()            // 跨站请求伪造防护禁用
                .cors();
    }
}
