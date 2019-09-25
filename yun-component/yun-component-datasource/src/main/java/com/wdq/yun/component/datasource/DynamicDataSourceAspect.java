package com.wdq.yun.component.datasource;

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

import lombok.extern.slf4j.Slf4j;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: TODO
 *
 */
@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("execution(public * com.wdq.yun.*.dao.*.*(..))")
    public void pointCut() {
    }
    @Before("pointCut()")
    public void before(JoinPoint point){
        System.out.println("---动态配置数据源---");
        Object target = point.getTarget();
        Class<?>[] clazzs = target.getClass().getInterfaces();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        if (method != null) {
            //获取数据源注解，切换对应数据源
            DataSource dataSource = method.getAnnotation(DataSource.class);
            if (null == dataSource) {
                DynamicDataSourceHolder.putDataSource(DynamicDataSourceGlobal.WRITE);
            }else {
                DynamicDataSourceHolder.putDataSource(dataSource.value());
            }
            log.error("Switch DataSource to [{}] in Method [{}] ",DynamicDataSourceHolder.getDataSource(),point.getSignature());
        }
    }

    @After("pointCut()")
    public void after(){
        DynamicDataSourceHolder.clearDataSource();
    }
}
