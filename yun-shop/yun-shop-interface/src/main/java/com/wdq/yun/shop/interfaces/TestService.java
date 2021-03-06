package com.wdq.yun.shop.interfaces;

import com.wdq.yun.domain.shop.entity.Shop;

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
@RequestMapping(value = "/test-service")
public interface TestService {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test();
}
