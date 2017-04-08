package com.endos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Endos on 2017/4/8.
 */
@SpringBootApplication
@EnableEurekaServer
public class SimpleDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleDiscoveryApplication.class, args);
    }
}
