package com.wdq.yun.test.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wudq
 * @date
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker
public class TestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class,args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    }
}
