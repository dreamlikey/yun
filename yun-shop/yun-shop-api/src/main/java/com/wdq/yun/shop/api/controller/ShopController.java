package com.wdq.yun.shop.api.controller;

import com.wdq.yun.domain.shop.Shop;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wudq
 * 2018/12/18
 */

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/{id}")
    public Shop getShop(@PathVariable Long id) {
        Shop shop = shopService.getById(id);
        System.out.println(shop.toString());
        return shop;
    }

    @GetMapping("/list")
    public Shop listShop() {
        Shop shop = shopService.getById(1);
        System.out.println(shop.toString());
        return shop;
    }

}
