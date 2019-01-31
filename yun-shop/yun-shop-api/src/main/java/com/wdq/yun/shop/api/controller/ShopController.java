package com.wdq.yun.shop.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.api.client.ShopClient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * @author wudq
 * 2018/12/18
 */

@RestController
public class ShopController {

    @Resource
    private ShopClient shopClient;

    @GetMapping(value = "/shop/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand(defaultFallback = "defaultGetSopById")
    public Shop getShop(@PathVariable long id) {
        Shop shop = shopClient.getById(id);
        System.out.println(shop.toString());
        return shop;
    }

    @GetMapping(value = "/shop/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand(defaultFallback = "defaultListShop")
    public List<Shop> listShop() {
        List<Shop> shops = shopClient.listAll();
        return shops;
    }

    @PostMapping(value = "/shop/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Shop shop) {
        shopClient.save(shop);
    }

    @PutMapping(value = "/shop/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Shop shop) {
        shopClient.listAll();
//        shopClient.checkShop(shop);
        shopClient.update(shop);
    }

    @HystrixCommand
    private Shop defaultGetSopById(@PathVariable long id) {
        System.out.println("执行getById熔断器");
        Shop shop = new Shop();
        shop.setShopName("默认店");
        return shop;
    }

    @HystrixCommand
    private List<Shop> defaultListShop() {
        List<Shop> shops = new ArrayList<>();
        System.out.println("执行getById熔断器");
        Shop shop = new Shop();
        shop.setShopName("默认店");
        shops.add(shop);
        return shops;
    }
}
