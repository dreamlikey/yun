package com.wdq.yun.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wudq
 * @date 2019/9/16
 * @Description:
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
