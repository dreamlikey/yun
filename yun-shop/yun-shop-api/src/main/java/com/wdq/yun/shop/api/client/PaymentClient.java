package com.wdq.yun.shop.api.client;

import com.wdq.yun.domain.shop.entity.Payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wudq
 * @date 2019/7/12 001211
 * @Description: TODO
 */
@FeignClient(value = "shop-service-provider")
public interface PaymentClient {
    @RequestMapping(value = "/payment-service/pay", method = RequestMethod.POST)
    public void pay(@RequestBody Payment payment);
}
