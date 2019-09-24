package com.wdq.yun.test.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wudq
 * @date 2019/09/24
 * @Description:
 */
@SpringBootApplication(scanBasePackages={"com.wdq.yun.test.*"})
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class TestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class,args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
    }
}
