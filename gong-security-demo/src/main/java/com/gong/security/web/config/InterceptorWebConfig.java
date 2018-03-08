package com.gong.security.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by GongWenHua on 17.12.25.
 */
//@Configuration
public class InterceptorWebConfig extends WebMvcConfigurerAdapter {

    //    @Autowired
    //    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // 针对异步的Callable请求设置拦截器
//        configurer.registerCallableInterceptors()
        // 针对异步的Deferred请求设置拦截器
//        configurer.registerDeferredResultInterceptors()
        // 针对异步请求的超时时间
//        configurer.setDefaultTimeout()
        // 自定义异步请求的线程池，设置可重用
//        configurer.setTaskExecutor()
    }
}
