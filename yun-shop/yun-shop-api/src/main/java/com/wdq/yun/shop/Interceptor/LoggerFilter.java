package com.wdq.yun.shop.Interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import java.io.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wudq
 * @date 2019/1/11
 * @Description: TODO
 */
public class LoggerFilter extends AbstractRequestLoggingFilter {
    private static final Logger log = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Http请求：{}",request.getRequestURI());
        System.out.println("Http请求");
    }

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String s) {
        String requestUri = httpServletRequest.getRequestURI();
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {
        log.info("Http请求：{}",s);
        System.out.println("Http请求");
    }
}
