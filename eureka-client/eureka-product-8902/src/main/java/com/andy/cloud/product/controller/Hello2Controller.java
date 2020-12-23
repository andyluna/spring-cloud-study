package com.andy.cloud.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2020/12/22 十二月 09:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class Hello2Controller {

    @Value("${server.port:8902}")
    private Integer port;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(required = false,defaultValue = "andy") String name){
        log.debug("name:{} port:{}",name,port);
        String res = "你好"+name+"这是端口"+port+"返回的数据";
        return res;
    }

}
