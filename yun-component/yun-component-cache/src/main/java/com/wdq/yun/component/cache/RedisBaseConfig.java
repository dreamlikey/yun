package com.wdq.yun.component.cache;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wudq
 * @date 2019/7/16
 * @Description:
 */
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
