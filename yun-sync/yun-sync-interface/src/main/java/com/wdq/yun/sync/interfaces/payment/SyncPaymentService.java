package com.wdq.yun.sync.interfaces.payment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wudq
 * @date 2019/6/19
 * @Description: TODO
 */
@ResponseBody
@RequestMapping("/sync-payment")
public interface SyncPaymentService {

    @PostMapping("/ali_pay")
    void aliPayEvent(@RequestParam("amount") double amount);

    @PostMapping("/wechat_pay")
    void wechatPayEvent();
}
