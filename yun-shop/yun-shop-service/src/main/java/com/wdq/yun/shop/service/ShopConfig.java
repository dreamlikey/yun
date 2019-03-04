package com.wdq.yun.shop.service;

import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wudq
 * @date 2019/2/22 002213
 * @Description: TODO
 */
@Configuration
public class ShopConfig {

    @Bean(name="shopBean")
    public Shop shop() {
        Shop shop = new Shop();
        shop.setShopName("Bean");
        return shop;
    }
}
