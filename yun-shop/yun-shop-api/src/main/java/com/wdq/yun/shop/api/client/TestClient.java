package com.wdq.yun.shop.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "shop-service-provider")
public interface TestClient {

    @RequestMapping(value = "/test-service/test", method = RequestMethod.GET)
    String test();
}
