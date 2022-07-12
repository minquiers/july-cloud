package com.july.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JulyCloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JulyCloudAuthApplication.class, args);
    }

}
