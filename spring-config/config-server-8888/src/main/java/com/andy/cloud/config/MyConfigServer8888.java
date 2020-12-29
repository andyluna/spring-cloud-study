package com.andy.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @time: 2020/12/26 十二月 09:45
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootApplication
@EnableConfigServer
public class MyConfigServer8888 {

    public static void main(String[] args) {
        SpringApplication.run(MyConfigServer8888.class, args);
    }

}
