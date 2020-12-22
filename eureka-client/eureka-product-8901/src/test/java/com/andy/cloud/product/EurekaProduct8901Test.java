package com.andy.cloud.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @time: 2020/12/21 十二月 11:01
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@SpringBootTest
@Slf4j
public class EurekaProduct8901Test {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        log.info("context:{}",context);
    }

}