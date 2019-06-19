package com.wdq.yun.shop.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wudq
 * @date 2019/6/19
 * @Description: TODO
 */
@FeignClient(value = "sync-provider")
public interface SyncPaymentClient {

    @RequestMapping(value = "/sync-payment/ali_pay", method = RequestMethod.POST)
    void aliPayEvent();

    @RequestMapping(value = "/sync-payment/wechat_pay", method = RequestMethod.POST)
    void wechatPayEvent();
}
