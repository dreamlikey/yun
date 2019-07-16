package com.wdq.yun.sync.service.observe;


import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

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
        System.out.println("开始复核，支付信息："+arg.toString());
    }

}
