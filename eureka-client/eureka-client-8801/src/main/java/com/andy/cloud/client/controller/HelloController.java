package com.andy.cloud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2020/12/17 十二月 17:30
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(String name){
        log.info("hello:{}",name);
        return "hello"+name;
    }

}
