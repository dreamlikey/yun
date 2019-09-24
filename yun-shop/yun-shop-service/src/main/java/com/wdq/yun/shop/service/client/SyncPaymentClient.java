package com.wdq.yun.shop.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wudq
 * @date 2019/6/19
 * @Description: TODO
 */
@FeignClient(value = "sync-provider")
public interface SyncPaymentClient {

    @RequestMapping(value = "/sync-payment/ali_pay", method = RequestMethod.POST)
    void aliPayEvent(@RequestParam("amount") double amount);

    @RequestMapping(value = "/sync-payment/wechat_pay", method = RequestMethod.POST)
    void wechatPayEvent(double amount);
}
