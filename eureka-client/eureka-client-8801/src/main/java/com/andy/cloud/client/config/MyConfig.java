package com.andy.cloud.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @time: 2020/12/23 十二月 10:13
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
