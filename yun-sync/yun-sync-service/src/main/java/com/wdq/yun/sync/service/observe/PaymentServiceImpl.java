package com.wdq.yun.sync.service.observe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Observable;

import javax.annotation.PostConstruct;

/**
 * 支付
 * @author wudq
 * @date 2019/7/12
 * @Description: 被观察者
 */
@Component
public class PaymentServiceImpl extends Observable {

    @Autowired
    private ReviewServiceImpl review;

    /**
     * 支付
     */
    public void pay() {
        System.out.println("支付");
        Payment payment = new Payment();
        payment.setAmount(100.0);
        payment.setCarNo("123233daa");
        payment.setPayTime(new Date());
        super.notifyObservers(payment);
    }

    @PostConstruct
    public void addObserver() {
        super.addObserver(review);
    }
}
