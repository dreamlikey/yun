package com.wdq.yun.common.annotation;

import com.wdq.yun.common.constant.DynamicDataSourceGlobal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: 数据源类型注解，默认读
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {

    DynamicDataSourceGlobal value() default DynamicDataSourceGlobal.READ;
}
