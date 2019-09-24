package com.wdq.yun.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 校验
 * @author wudq
 * @date 2019/9/16
 * @Description: TODO
 */
public class ValidateFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, HttpCookie> cookieMap = request.getCookies();
        HttpHeaders headers = request.getHeaders();
        MultiValueMap<String, String> paramsMap =  request.getQueryParams();
        Flux<DataBuffer> body = request.getBody();
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
