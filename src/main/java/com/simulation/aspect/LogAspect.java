package com.simulation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(* com.simulation.controller.TestController.*(..))")
    public void	point(){
    }


    @Around("point()")
    public Object test(ProceedingJoinPoint pjp){
        //1. 获取方法参数
        Object[] methodArgs = pjp.getArgs();
        //2. 获取正在执行的类和方法

        //pjp.getSignature().getName(); 方法名称
        String methodName = pjp.getSignature().toShortString();

        //3获取请求路径
        String name = pjp.getSignature().getName();


        String ipAddress = request.getRemoteAddr();
        logger.info("当前访问上下文信息:正在执行的方法:"+methodName+"方法参数:"+Arrays.toString(methodArgs)+"id:"+ipAddress);

        try {
            long start = System.currentTimeMillis();
            Object proceed = pjp.proceed();
            long end = System.currentTimeMillis();
            logger.info("执行请求耗时:"+(String.valueOf(end-start)));
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}