package com.wdq.yun.shop.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author wudq
 * @date 2019/3/8 000817
 * @Description: TODO
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringDaoConfig implements TransactionManagementConfigurer {
    @Autowired
    private DynamicDataSource dataSource;

    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DynamicDataSourceTransactionManager(dataSource);
    }
}