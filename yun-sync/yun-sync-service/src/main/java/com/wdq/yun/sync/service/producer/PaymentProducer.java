package com.wdq.yun.sync.service.producer;

import com.wdq.yun.sync.interfaces.payment.SyncPaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wudq
 * @date 2019/6/19
 * @Description:
 */
@Service
public class PaymentProducer implements SyncPaymentService {

    @Autowired
    public KafkaTemplate kafkaTemplate;

    @Override
    public void aliPayEvent(double amount) {
        System.out.println("支付数据同步");
        kafkaTemplate.send("payment","支付宝到账"+amount+"元");
    }

    @Override
    public void wechatPayEvent() {
        System.out.println("支付数据同步");
        kafkaTemplate.send("payment","微信到账10000000元");
    }

}
