package com.andy.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @time: 2020/12/16 十二月 16:16
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootApplication
@EnableFeignClients
public class EurekaClient8802 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8802.class, args);
    }
}
