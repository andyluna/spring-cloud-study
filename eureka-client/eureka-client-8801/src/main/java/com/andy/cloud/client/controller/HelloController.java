package com.andy.cloud.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @time: 2020/12/17 十二月 17:30
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;



    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHello")
    public String sayHello(String name){
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject("http://eurekaclient:8901/hello/sayHello?name="+name, String.class);
        log.info("hello:{}",object);
        return "客户端--object"+object;
    }


    @GetMapping("/sayHello1")
    public String sayHello1(String name){
        ServiceInstance instance = loadBalancerClient.choose("ENREKA-PRODCUT");
        RestTemplate restTemplate = new RestTemplate();
        String object = restTemplate.getForObject(instance.getUri()+"/hello/sayHello?name="+name, String.class);
        log.info("hello:{}",object);
        return "客户端--object"+object;
    }



    @GetMapping("/sayHello2")
    public String sayHello2(String name){
        String object = restTemplate.getForObject("http://ENREKA-PRODCUT/hello/sayHello?name="+name, String.class);
        log.info("hello:{}",object);
        return "客户端--object"+object;
    }




}
