package com.interfaces;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/12.
 */
@Aspect
@Service
public class UserInterceptor {
    Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
    @Before("execution(* com.lc.MvcController.*(..))")
    public void before(JoinPoint joinPoint){
       String className = joinPoint.getTarget().getClass().getName();
        logger.debug("LCLC-%%%%"+className);
    }
    /*@Around("execution(* com.lc.MvcController.*(..))")
    public Object InvokeMethod(ProceedingJoinPoint thisJoinPoint) throws Throwable{
        logger.debug("LCLCLCLC>>>>GGGG");
        System.out.println("LCLC>>interceptor...");
        return thisJoinPoint.proceed();
    }*/

}
