package com.wdq.yun.component.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author wudq
 * @date 2019/3/4
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.write")
    public DataSource writeDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.read")
    public DataSource readDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.druid.sharding")
    public DataSource shardingDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        DataSource writeDataSource = writeDataSource();
        DataSource readDataSource = readDataSource();
//        DataSource shardingDataSource = shardingDataSource();
        List<DataSource> readDataSources = new ArrayList<>();
        readDataSources.add(readDataSource);
        /** 读*/
        dynamicDataSource.setWriteDataSource(writeDataSource);
        /** 写*/
        dynamicDataSource.setReadDataSources(readDataSources);
        /** mycat分片*/
//        dynamicDataSource.setShardingDataSource(shardingDataSource);
        return dynamicDataSource;
    }

}
