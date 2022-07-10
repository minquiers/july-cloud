package com.july.cloud.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 字典启动程序
 */
@SpringBootApplication
public class JulyCloudDictionaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(JulyCloudDictionaryApplication.class, args);
    }
}
