package com.wdq.yun.test.api.client;

import com.wdq.yun.domain.test.entity.Tmsbill;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wudq
 * @date
 * @Description: TODO
 */

@FeignClient(value = "test-service-provider")
public interface TmsbillClient {
    @RequestMapping(value = "/test-service/save", method = RequestMethod.POST)
    void save(@RequestBody Tmsbill bill);

    @RequestMapping(value = "/test-service/get", method = RequestMethod.GET)
    Tmsbill getById(@RequestParam("id") long id);

    @RequestMapping(value = "/test-service/list", method = RequestMethod.GET)
    List<Tmsbill> listAll();

    @RequestMapping(value = "/test-service/update", method = RequestMethod.PUT)
    Long update(@RequestBody Tmsbill bill);

}
