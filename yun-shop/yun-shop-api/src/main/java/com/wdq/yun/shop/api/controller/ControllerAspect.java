package com.wdq.yun.shop.api.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wudq
 * @date 2019/3/5 000509
 * @Description: TODO
 */
//@Component
//@Aspect
public class ControllerAspect {

    @Pointcut("execution(public * com.wdq.yun.shop.api.controller..*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint point) {
        System.out.println("---before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("---after");
    }
}
