package com.wdq.yun.gateway.config;

import com.wdq.yun.gateway.filter.ElapsedFilter;
import com.wdq.yun.gateway.filter.RateLimitByIpGatewayFilter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description:
 */
@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/shopapi/**")
                .filters(f -> f.stripPrefix(0)
                    .filter(new ElapsedFilter())
                    .filter(new RateLimitByIpGatewayFilter())
                    .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                .uri("http://192.168.8.112:8083")
                .order(0)
                .id("shop-api"))
            .build();
    }
}
