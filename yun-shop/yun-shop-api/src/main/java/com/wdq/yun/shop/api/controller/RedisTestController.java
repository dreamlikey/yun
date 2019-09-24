package com.wdq.yun.shop.api.controller;


import com.wdq.yun.component.cache.RedisService;
import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisService redisService;

    @GetMapping(value = "/set")
    public void test() throws Exception {
        Shop shop = new Shop();
        shop.setShopName("teer");
        shop.setCreateTime(new Date());
        redisService.set("test1",shop.toString());
    }

    @GetMapping(value = "/setobj")
    public void testSetObj() throws Exception {
        Shop shop = new Shop();
        shop.setShopName("teer");
        shop.setCreateTime(new Date());
        redisService.set("ship",shop);
    }

    @GetMapping(value = "/get")
    public Object get() {
        String res = redisService.get("ship");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @GetMapping(value = "/getObj")
    public Object getObj() {
        System.out.println("-------getObj");
        Shop res = redisService.getObj("ship", Shop.class);
        return res;
    }

}
