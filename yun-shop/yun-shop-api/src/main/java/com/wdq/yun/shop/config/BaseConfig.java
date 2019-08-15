package com.wdq.yun.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wudq
 * @date 2019/7/16
 * @Description:
 */
@Configuration
@ImportResource("classpath:cache-redis.xml")
public class BaseConfig {
}