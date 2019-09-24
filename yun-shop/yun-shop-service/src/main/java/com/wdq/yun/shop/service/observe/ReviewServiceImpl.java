package com.wdq.yun.shop.service.observe;


import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * 财务复核
 * @author wudq
 * @date 2019/7/12
 * @Description: 观察者
 */
@Component
public class ReviewServiceImpl implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始复核，支付信息："+arg.toString());
    }

}
