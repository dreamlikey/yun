package com.wdq.yun.shop.api.controller;

import com.wdq.yun.domain.shop.entity.Payment;
import com.wdq.yun.shop.api.client.PaymentClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.annotation.Resource;

/**
 * 支付
 * @author wudq
 * @date 2019/7/12
 * @Description:
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentClient paymentClient;

    @RequestMapping("/pay")
    public void pay() {
        Payment payment = new Payment();
        payment.setAmount(1000.0);
        payment.setCarNo("s23545279cf");
        payment.setPayTime(new Date());
        paymentClient.pay(payment);
    }
}
