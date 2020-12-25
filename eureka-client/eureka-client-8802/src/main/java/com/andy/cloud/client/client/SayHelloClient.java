package com.andy.cloud.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @time: 2020/12/24 十二月 09:39
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@FeignClient(name="ENREKA-PRODCUT")
public interface SayHelloClient {

    @GetMapping("/hello/sayHello")
    String sayHello(@RequestParam("name") String name);

    @GetMapping("/hello/sayHello")
    String sayHello1(@RequestParam Map<String,Object> map);
}
