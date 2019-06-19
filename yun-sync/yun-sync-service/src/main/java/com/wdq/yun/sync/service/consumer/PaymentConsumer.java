package com.wdq.yun.sync.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author wudq
 * @date 2019/6/19 001916
 * @Description: TODO
 */
@Component
public class PaymentConsumer {

    @KafkaListener(topics = "payment")
    public void alipayConsumer(ConsumerRecord cr) {
        System.out.println("支付数据消费："+cr.toString());
    }
}
