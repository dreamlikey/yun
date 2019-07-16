package com.wdq.yun.shop.observe;

import com.wdq.yun.domain.shop.entity.Payment;
import com.wdq.yun.shop.interfaces.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
public class PaymentServiceImpl extends Observable implements PaymentService {

    @Autowired
    private ReviewServiceImpl review;

    /**
     * 支付
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pay(Payment payment) {
        System.out.println("支付");
        super.setChanged();
        super.notifyObservers(payment);
        System.out.println("支付完成");
    }

    /**
     * 注册观察者
     */
    @PostConstruct
    public void addObserver() {
        super.addObserver(review);
    }

}
