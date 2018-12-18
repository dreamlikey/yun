package com.wdq.yun.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YunEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunEurekaApplication.class, args);
    }

}

