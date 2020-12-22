package com.andy.cloud.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;

/**
 * @time: 2020/12/21 十二月 10:35
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootApplication
@EnableJpaAuditing
public class EurekaProduct8901 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProduct8901.class,args);
    }

}
