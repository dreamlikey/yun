package com.wdq.yun.shop.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author wudq
 * @date 2019/3/4
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource writeDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        System.out.println("---创建写库dataSource---");
        return dataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.read.datasource")
    public List<DataSource> readDataSource() {
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        List<DataSource> dataSources = new ArrayList<>();
        dataSources.add(dataSource);
        System.out.println("---创建读库dataSource---");
        return dataSources;
    }

    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        DataSource writeDataSource = writeDataSource();
        List<DataSource> readDataSources = readDataSource();
        dynamicDataSource.setWriteDataSource(writeDataSource);
        dynamicDataSource.setReadDataSources(readDataSources);
        System.out.println("----数据源绑定成功----");
        return  dynamicDataSource;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource) {
//        return new DynamicDataSourceTransactionManager(dataSource);
//    }
}
