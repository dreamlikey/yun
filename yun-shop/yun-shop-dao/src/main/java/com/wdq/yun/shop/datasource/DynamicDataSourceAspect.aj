package com.wdq.yun.shop.datasource;

import com.wdq.yun.common.annotation.DataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: TODO
 *
 */
@Component
@Aspect
public class DynamicDataSourceAspect {

    @Pointcut("execution(* com.wdq.yun.shop.dao..*.*(..))")
    public void pointCut() {

    }

    @Before("execution(* com.wdq.yun.shop.dao.*.*(..))")
    public void before(JoinPoint point){
        System.out.println("before");
        Object target = point.getTarget();
        Class<?>[] clazz =target.getClass().getInterfaces();
        Annotation annotation = clazz[0].getAnnotation(DataSource.class);
        ((DataSource) annotation).value();
    }

    @After("pointCut()")
    public void after(){
        DynamicDataSourceHolder.holder.remove();
    }
}
