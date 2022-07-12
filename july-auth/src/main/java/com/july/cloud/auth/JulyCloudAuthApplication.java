package com.july.cloud.auth;

import com.july.cloud.common.core.annocation.EnableJulyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJulyFeignClients
public class JulyCloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JulyCloudAuthApplication.class, args);
    }

}
