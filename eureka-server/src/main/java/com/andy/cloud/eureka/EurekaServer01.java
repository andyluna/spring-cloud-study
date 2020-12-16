package com.andy.cloud.eureka;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @time: 2020/12/16 十二月 15:24
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer01 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(EurekaServer01.class)
                        .web(WebApplicationType.SERVLET)
                        .run(args);
    }


}
