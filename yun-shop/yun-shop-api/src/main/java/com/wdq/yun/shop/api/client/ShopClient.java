package com.wdq.yun.shop.api.client;

import com.wdq.yun.domain.shop.entity.Shop;
import com.wdq.yun.shop.fallback.ShopClientFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
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

@FeignClient(value = "shop-service-provider")
public interface ShopClient {
    @RequestMapping(value = "/shop-service/save", method = RequestMethod.POST)
    void save(@RequestBody Shop shop);

    @RequestMapping(value = "/shop-service/get", method = RequestMethod.GET)
    Shop getById(@RequestParam("id") long id);

    @RequestMapping(value = "/shop-service/list", method = RequestMethod.GET)
    List<Shop> listAll();

    @RequestMapping(value = "/shop-service/check", method = RequestMethod.GET)
    void checkShop(@RequestParam("id") Long id);

    @RequestMapping(value = "/shop-service/update", method = RequestMethod.PUT)
    Long update(@RequestBody Shop shop);
}
