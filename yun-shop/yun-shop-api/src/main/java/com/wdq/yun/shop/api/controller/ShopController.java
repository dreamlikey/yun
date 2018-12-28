package com.wdq.yun.shop.api.controller;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wudq
 * 2018/12/18
 */

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(value = "/shop/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Shop getShop(@PathVariable Long id) {
        Shop shop = shopService.getById(id);
        System.out.println(shop.toString());
        return shop;
    }

    @GetMapping("/shop/save")
    public void saveShop() {
        Shop shop = new Shop();
        shop.setShopName("adidas专卖店");
        shop.setLevel("10");
        shop.setShopNo("C02");
        shop.setdescription("adidas服饰官方商店");
        shop.setOwnerName("wyh");
        shopService.save(shop);
    }

    @GetMapping(value = "/shop/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Shop> listShop() {
        List<Shop> shops = shopService.listAll();
        return shops;
    }

}