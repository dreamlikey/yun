package com.wdq.yun.shop.datasource;

import com.wdq.yun.common.annotation.DataSource;
import com.wdq.yun.common.constant.DynamicDataSourceGlobal;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: TODO
 *
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("execution(public * com.wdq.yun.*.dao..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint point){
        System.out.println("---动态配置数据源---");
        Object target = point.getTarget();
        Class<?>[] clazzs =target.getClass().getInterfaces();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        if (method != null) {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            DynamicDataSourceHolder.putDataSource(dataSource.value());
            System.out.println("Switch DataSource to [{}] in Method [{}] " + DynamicDataSourceHolder.getDataSource() +"   "+ point.getSignature());
        }
    }

    @After("pointCut()")
    public void after(){
        DynamicDataSourceHolder.clearDataSource();
    }
}
