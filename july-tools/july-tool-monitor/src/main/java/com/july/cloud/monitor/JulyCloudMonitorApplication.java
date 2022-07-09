package com.july.cloud.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控中心
 */
@EnableAdminServer
@SpringBootApplication
@Slf4j
public class JulyCloudMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JulyCloudMonitorApplication.class, args);
    }
}
