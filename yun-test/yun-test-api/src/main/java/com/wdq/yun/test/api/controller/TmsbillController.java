package com.wdq.yun.test.api.controller;

import com.wdq.yun.domain.test.entity.Tmsbill;
import com.wdq.yun.test.api.client.TmsbillClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wudq
 * @date 2019/9/24
 * @Description: TODO
 */
@RestController
public class TmsbillController {
    @Resource
    private TmsbillClient billClient;

    @GetMapping(value = "/bill/{id}")
    public Tmsbill get(@PathVariable Long id) {
        return billClient.getById(id);
    }
}
