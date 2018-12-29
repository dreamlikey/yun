package com.wdq.yun.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wudq
 * @date 2018/12/28 002815
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ShopServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServiceApplication.class,args);
    }
}
