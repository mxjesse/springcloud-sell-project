package com.mx.sellobjserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SellObjServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellObjServerApplication.class, args);
    }

}
