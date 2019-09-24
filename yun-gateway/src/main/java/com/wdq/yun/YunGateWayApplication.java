package com.wdq.yun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.wdq.yun.gateway"},exclude= {DataSourceAutoConfiguration.class})
public class YunGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunGateWayApplication.class, args);
    }


}

