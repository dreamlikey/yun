package com.wdq.yun.shop;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.service.impl.ShopConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wudq
 * @date 2018/12/28
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ShopServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopServiceApplication.class,args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ShopConfig.class);
        context.refresh();
        Shop shop = (Shop) context.getBean("shopBean");
        System.out.println(shop.getShopName());
    }
}
