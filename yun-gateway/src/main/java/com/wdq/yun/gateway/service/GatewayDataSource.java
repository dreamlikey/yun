package com.wdq.yun.gateway.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 * @author wudq
 * @date 2019/9/17
 * @Description: TODO
 */
@Component
public class GatewayDataSource implements InitializingBean {

    private JdbcTemplate jdbcTemplate;

    public void getDataSource() {
        System.out.println("-----初始化JdbcTemplate");
        String url = "jdbc:mysql://192.168.8.112:3306/config?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,"root","123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Bean(name="jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        return this.jdbcTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        getDataSource();
    }
}
