package com.wdq.yun.shop.datasource;

import com.wdq.yun.common.constant.DynamicDataSourceGlobal;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.sql.DataSource;

/**
 * @author wudq
 * @date 2019/3/4
 * @Description: 动态数据源实现读写分离
 */
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    private DataSource writeDataSource;

    private List<DataSource> readDataSources;


    /***
     * 声明与当前线程绑定的lookup key，
     *
     */
    @Override
    protected Object determineCurrentLookupKey() {

        DynamicDataSourceGlobal dataSourceGlobal= DynamicDataSourceHolder.getDataSource();
        if (dataSourceGlobal == null || dataSourceGlobal == DynamicDataSourceGlobal.WRITE) {
            return DynamicDataSourceGlobal.WRITE.name();
        }
        int index = ThreadLocalRandom.current().nextInt(0, readDataSources.size());
        return dataSourceGlobal.name();
    }

    /**
     * 数据源初始化
     */
    @Override
    public void afterPropertiesSet() {

        if (writeDataSource == null) {
            throw new IllegalArgumentException("Property 'writeDataSource' is required");
        }
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DynamicDataSourceGlobal.WRITE.name(), writeDataSource);
        for (int i = 0; i < readDataSources.size(); i++) {
            targetDataSources.put(DynamicDataSourceGlobal.READ.name(), readDataSources.get(i));
        }

        //声明当前的dataSource
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    public void setWriteDataSource(DataSource writeDataSource) {
        this.writeDataSource = writeDataSource;
    }

    public void setReadDataSources(List<DataSource> readDataSources) {
        this.readDataSources = readDataSources;

    }
}
