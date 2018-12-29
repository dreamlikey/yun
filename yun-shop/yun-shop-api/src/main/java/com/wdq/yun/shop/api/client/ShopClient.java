package com.wdq.yun.shop.api.client;

import com.wdq.yun.shop.interfaces.ShopService;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wudq
 * @date 2018/12/28 002814
 * @Description: TODO
 */

@FeignClient("shop-service")
public interface ShopClient extends ShopService {
}
