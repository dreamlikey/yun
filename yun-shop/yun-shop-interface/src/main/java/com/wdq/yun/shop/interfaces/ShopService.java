package com.wdq.yun.shop.interfaces;

import com.wdq.yun.common.interfaces.BaseService;
import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 2018/12/18
 * 坑
 * 1、@RequestParam 不加尽管指定了请求方式为GET但Feign依然会发送POST请求，然后报错
 * 2、@RequestBody 传递对象参数，接口、实现都需要对参数声明
 * 3、Feign发送GET请求不能传对象
 *
 */
//service-provider-shop
@RequestMapping("shop-service")
public interface ShopService {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void save(@RequestBody  Shop shop);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Shop getById(@RequestParam("id") long id);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Shop> listAll();

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    void checkShop(@RequestParam("id") Long id);

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    Long update(@RequestBody Shop shop);
}
