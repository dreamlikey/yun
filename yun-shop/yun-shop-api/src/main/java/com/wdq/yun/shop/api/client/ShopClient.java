package com.wdq.yun.shop.api.client;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.fallback.ShopClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wudq
 * @date 2018/12/28
 * @Description: TODO
 */

@FeignClient(value = "shop-service", fallback = ShopClientFallback.class)
public interface ShopClient {
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void save(@RequestBody Shop shop);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Shop getById(@RequestParam("id") long id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Shop> listAll();

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    void checkShop(@RequestParam("id") Long id);

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    Long update(@RequestBody Shop shop);
}
