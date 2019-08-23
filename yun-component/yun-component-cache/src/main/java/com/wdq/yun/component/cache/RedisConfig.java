package com.wdq.yun.component.cache;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wudq
 * @date 2019/7/16
 * @Description:
 */
@Configuration
@EnableApolloConfig(value = {"TEST1.redis"})
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    @Autowired
    private RedisBaseConfig redisBaseConfig;

    @Bean
    public RedisBaseConfig redisBaseConfig() {
        return new RedisBaseConfig();
    }

    /**
     * 连接池配置
     * @return
     */
    @Bean(name="jedisPoolConfig")
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 连接池最大连接数（使用负值表示没有限制）
        jedisPoolConfig.setMaxTotal(redisBaseConfig.getMaxTotal());
        // 连接池最大阻塞等待时间（使用负值表示没有限制）
        jedisPoolConfig.setMaxWaitMillis(redisBaseConfig.getMaxWaitMillis());
        // 连接池中的最大空闲连接
        jedisPoolConfig.setMaxIdle(redisBaseConfig.getMaxIdle());
        // 连接池中的最小空闲连接
        jedisPoolConfig.setMinIdle(redisBaseConfig.getMinIdle());
        return jedisPoolConfig;
    }


    /**
     * 连接工厂
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        //单机配置
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisBaseConfig.getHost());
        config.setPort(redisBaseConfig.getPort());
        config.setDatabase(redisBaseConfig.getDatabase());
        //客户端配置（使用连接池）
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.
                                                                builder().
                                                                usePooling().
                                                                poolConfig(jedisPoolConfig).
                                                                build();
        //单机配置 + 连接池
        RedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(config,jedisClientConfiguration);
        return redisConnectionFactory ;
    }

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setHashValueSerializer(fastJsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
