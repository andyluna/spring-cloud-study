package com.andy.cloud.client.controller;

import com.andy.cloud.client.client.SayHelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @time: 2020/12/24 十二月 09:41
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class TestHelloController {

    @Autowired
    private SayHelloClient sayHelloClient;

    @GetMapping("/sayHello")
    public String sayHello(String name){
        log.info("name=:{}",name);
        String hello = sayHelloClient.sayHello(name);
        log.info("res={}",hello);
        return "客户端返回"+hello;

    }


    @GetMapping("/sayHello1")
    public String sayHello1(String name){
        log.info("name1=:{}",name);
        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        String hello = sayHelloClient.sayHello1(map);
        log.info("res1={}",hello);
        return "客户端返回"+hello;

    }

}
