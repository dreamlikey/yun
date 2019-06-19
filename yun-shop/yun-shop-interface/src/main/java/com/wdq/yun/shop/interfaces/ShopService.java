package com.wdq.yun.shop.interfaces;

import com.wdq.yun.domain.shop.entity.Shop;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 2018/12/18
 * 坑
 * 1、@RequestParam 不加尽管指定了请求方式为GET但Feign依然会发送POST请求，然后报错
 * 2、@RequestBody 传递对象参数，接口、实现都需要对参数声明
 * 3、Feign发送GET请求不能传对象
 * 巨坑：
 * 1、@RestController，如果不加@ResponseBody注解spring web会将请求当成视图解析，最终导致结果是找不到视图的url，404
 *   也可以@RestController，它包含了@ResponseBody注解
 *
 *
 */
//service-provider-shop
@ResponseBody
@RequestMapping(value = "/shop-service")
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    Shop test();

    @RequestMapping(value = "/ali_pay", method = RequestMethod.GET)
    void payByAlipay();


}
