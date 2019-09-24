package com.wdq.yun.shop.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wudq
 * @date 2019/8/21
 * @Description:
 */
@Configuration
@ImportResource({"classpath:cache-redis.xml",
                 "classpath:component-datasource.xml",
                 "classpath:component-log.xml"})
public class BaseConfig {
}
