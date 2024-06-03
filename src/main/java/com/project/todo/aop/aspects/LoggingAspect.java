package com.project.todo.aop.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

//Configuration
//AOP
@Configuration
@Aspect
@Slf4j
public class LoggingAspect {


    //PointCut - When?
    // execution(* PACKAGE.*.*(..))
    //@Pointcut("execution(* com.project.todo.aop.business.*.*(..))")
    @Before("execution(* com.project.todo.aop.business.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        //Logic - What?
        log.info("Before Aspect Business Method called - {}", joinPoint);
    }

    @Before("execution(* com.project.todo.aop.data.*.*(..))")
    public void logDataMethodCall(JoinPoint joinPoint){
        //Logic - What?
        log.info("Before Aspect Data Method called - {}", joinPoint);
    }

}
