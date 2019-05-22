package com.mx.sellprojectzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy
public class SellProjectZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellProjectZuulApplication.class, args);
    }

}
