package com.wdq.yun.component.cache;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/7/16
 * @Description:
 */
@Data
public class RedisBaseConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.database}")
    private int database;

    //    @Value("${spring.redis.password:}")
    private String password;

    // 连接池最大连接数（使用负值表示没有限制）
    private int maxTotal = 10;
    // 连接池最大阻塞等待时间（使用负值表示没有限制）
    private int maxWaitMillis = 8;
    // 连接池中的最大空闲连接
    private int maxIdle = 8;
    // 连接池中的最小空闲连接
    private int minIdle = 3;
}
