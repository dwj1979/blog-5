package com.gong.security.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by GongWenHua on 17.12.17.
 * Filter -> Interceptor -> ControllerAdvice -> Aspect -> Controller
 */
@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.gong.security.web.controller.*.*(..))")
    public Object handleController(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("切面开始");
        Object[] args = pjp.getArgs();
        System.out.println("切面参数值:");
        for(Object arg:args){
            System.out.println(arg);
        }
        // 执行Controller
        Object result = pjp.proceed();
        System.out.println("切面结束");
        return result;
    }
}
