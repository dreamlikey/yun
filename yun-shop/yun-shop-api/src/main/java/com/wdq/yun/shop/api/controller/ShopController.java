package com.wdq.yun.shop.api.controller;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.api.client.ShopClient;
import com.wdq.yun.shop.api.client.TestClient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private TestClient testClient;

    @GetMapping(value = "/shop/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop getShop(@PathVariable long id) {
        Shop shop = shopClient.getById(id);
        System.out.println(shop.toString());
        return shop;
    }

    @GetMapping(value = "/shop/list", produces = MediaType.APPLICATION_JSON_VALUE)
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


    @GetMapping(value = "/shop/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test() {
        String resp = testClient.test();
        return resp;
    }
}
