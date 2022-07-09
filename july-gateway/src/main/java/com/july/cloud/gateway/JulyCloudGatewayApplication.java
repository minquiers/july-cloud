package com.july.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JulyCloudGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(JulyCloudGatewayApplication.class, args);
    }
}
