package com.gong.security.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤器：最原始的请求
 * Filter -> Interceptor -> ControllerAdvice -> Aspect -> Controller
 * Created by GongWenHua on 17.12.18.
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行");
        Long start = new Date().getTime();
        servletRequest.setAttribute("start",start);
        // 接着传递给拦截器
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器统计耗时"+(new Date().getTime() - start));
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
