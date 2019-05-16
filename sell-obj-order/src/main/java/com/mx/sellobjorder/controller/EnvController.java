package com.mx.sellobjorder.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mx
 * @date 2019/5/10 6:17 PM
 */
@RestController
@RequestMapping("/env")
@RefreshScope
public class EnvController {

    @Value("${env}")
    private String env;

//    @Value("${name}")
//    private String name;


    @GetMapping("/get")
    public String getEnv() {

        return env;
    }

//    @GetMapping("/name")
//    public String getName() {
//
//        return name;
//    }
}
