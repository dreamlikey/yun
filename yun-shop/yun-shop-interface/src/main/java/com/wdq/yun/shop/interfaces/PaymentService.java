package com.wdq.yun.shop.interfaces;

import com.wdq.yun.domain.shop.entity.Payment;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wudq
 * @date 2019/7/12
 * @Description: TODO
 */
@ResponseBody
@RequestMapping(value = "/payment-service")
public interface PaymentService {
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    void pay(@RequestBody Payment payment);
}
