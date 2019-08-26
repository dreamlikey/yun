package com.wdq.yun.component.log;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/8/23
 * @Description: logback配置
 */
@Data
@Configuration
@EnableApolloConfig(value = {"TEST1.logback"})
public class LogbackBaseConfig {

    @Value("${log.root.level}")
    private String level;

    @Value("${log.path}")
    private String path;

    @Value("${env}")
    private String env;

//    @Bean
//    public LogbackBaseConfig logbackBaseConfig() {
//        return new LogbackBaseConfig();
//    }

}
