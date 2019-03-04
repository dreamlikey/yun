package com.wdq.yun.shop.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: 动态数据源实现读写分离
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Object writeDataSource;

    private List<Object> readDataSource;


    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }


    @Override
    public void afterPropertiesSet() {

    }
}
