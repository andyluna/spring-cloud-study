package com.andy.cloud.product.controller;


import com.andy.cloud.product.EurekaProduct8901;
import com.andy.cloud.product.EurekaProduct8901Test;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.ws.rs.core.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @time: 2020/12/22 十二月 11:17
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@AutoConfigureMockMvc
@Slf4j
public class HelloControllerTest extends EurekaProduct8901Test {
    private static final String mediaType = "application/json;charset=utf-8";
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sayHello() throws Exception {
        log.info("mockMvc:{}",mockMvc);
        MvcResult result = mockMvc.perform(get("/hello/sayHello?name=张三")
                .accept(mediaType))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())    //将返回结果打印出来
                //断言：返回内容里根节点下有个error节点（JsonPath是用来访问json文件里指定信息的库，用法见下图）
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}