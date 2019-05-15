package com.mx.sellobjconfig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mx
 * @date 2019/5/13 5:58 PM
 */
@RestController
public class MyController {

    @RequestMapping("/hello")
    public String hello() {
        return "<html><body><h1>你是个大傻子</h1></body></html>";
    }
}
