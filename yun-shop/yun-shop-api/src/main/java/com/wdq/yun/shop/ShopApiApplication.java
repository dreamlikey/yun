package com.wdq.yun.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopApiApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "shop api";
    }
}
