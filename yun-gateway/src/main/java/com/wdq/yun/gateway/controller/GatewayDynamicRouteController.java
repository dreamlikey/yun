package com.wdq.yun.gateway.controller;

import com.wdq.yun.gateway.domain.GatewayFilterDefinition;
import com.wdq.yun.gateway.domain.GatewayPredicateDefinition;
import com.wdq.yun.gateway.domain.GatewayRoute;
import com.wdq.yun.gateway.service.GatewayRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import reactor.core.publisher.Mono;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description:
 */

@RestController
public class GatewayDynamicRouteController {

    @Autowired
    private GatewayRouteService gatewayRouteService;

    @PostMapping("/routes")
    public Mono<ResponseEntity<Void>> create(@RequestBody Mono<GatewayRoute> route) {

        GatewayRoute gatewayRoute = new GatewayRoute();
        GatewayPredicateDefinition predicateDefinition = new GatewayPredicateDefinition();

        List<GatewayPredicateDefinition> list = new ArrayList<>();
        list.add(predicateDefinition);
        gatewayRoute.setPredicates(list);

        predicateDefinition.setName("Path");
        predicateDefinition.getArgs().put("pattern","/shopapi/**");
        gatewayRoute.setRouteId("12323");
        gatewayRoute.setCreateTime(new Date());
        gatewayRoute.setUri("/test");
        gatewayRouteService.create(gatewayRoute);
        return Mono.empty();
    }

    @GetMapping("/routes/create")
    public Mono<ResponseEntity<Void>> test() {

        GatewayRoute gatewayRoute = new GatewayRoute();
        GatewayPredicateDefinition predicateDefinition = new GatewayPredicateDefinition();

        List<GatewayPredicateDefinition> list = new ArrayList<>();
        list.add(predicateDefinition);
        gatewayRoute.setPredicates(list);

        predicateDefinition.setName("Path");
        predicateDefinition.getArgs().put("pattern","/shopapi/**");
        gatewayRoute.setRouteId("12323");
        gatewayRoute.setCreateTime(new Date());
        gatewayRoute.setUri("/test");
        gatewayRouteService.create(gatewayRoute);
        return Mono.empty();
    }



    @GetMapping("/routes/{id}")
    public void get(@PathVariable Long id) {
        GatewayRoute gatewayRoute = gatewayRouteService.getGatewayRouteById(id);
        System.out.println(gatewayRoute.toString());
    }
}
