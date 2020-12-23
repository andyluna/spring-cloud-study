package com.andy.cloud.product.controller;

import com.andy.cloud.product.EurekaProduct8901Test;
import com.andy.cloud.product.entity.ProductInfo;
import com.andy.cloud.product.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @time: 2020/12/22 十二月 11:13
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@AutoConfigureMockMvc
@Slf4j
class ProductInfoControllerTest extends EurekaProduct8901Test  {
    private static final String basepath = "/productinfo";
    private static final String mediaType = "application/json;charset=utf-8";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(basepath + "/1").accept(mediaType))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("getById = {}",result.getResponse().getContentAsString());
    }

    @Test
    public void getByCode()throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(basepath + "/getByCode")
                .accept(mediaType)
                .param("productCode", "10001")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("getByCode = {}",result.getResponse().getContentAsString());
    }

    @Test
    public void getAllByIds()throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(basepath + "/getAllByIds")
                .accept(mediaType)
                //.param("ids", "1","2","3","4","5","6","7")
                .queryParam("ids", "1,2,3,4,5,6,7")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("getAllByIds = {}",result.getResponse().getContentAsString());
    }

    @Test
    public void save()throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(basepath + "/save")
                .accept(mediaType)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"productName\":\"针织衫\",\"productCode\":\"10002\",\"productPrice\":223.45}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("save = {}",result.getResponse().getContentAsString());
    }


    @Test
    public void update()throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(basepath + "/update")
                .accept(mediaType)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":14,\"productName\":\"羊毛衫444\",\"productCode\":\"1234\",\"productPrice\":134.55}")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("update = {}",result.getResponse().getContentAsString());
    }

    @Test
    public void deleteById()throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .delete(basepath + "/deleteById/14")
                .accept(mediaType)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("deleteById = {}",result.getResponse().getContentAsString());
    }
    @Test
    public void deleteByCode()throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .delete(basepath + "/deleteByCode")
                .accept(mediaType)
                .param("productCode", "10002")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("deleteById = {}",result.getResponse().getContentAsString());
    }

    @Test
    public void deleteByIds() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .delete(basepath + "/deleteByIds")
                .accept(mediaType)
                .param("ids", "2,3,4")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("deleteByIds = {}",result.getResponse().getContentAsString());
    }


    /*



    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        int n = productInfoService.deleteById(id);
        return "删除成功"+n;
    }

    @DeleteMapping("/deleteByCode")
    public String deleteByCode(String productCode){
        int n = productInfoService.deleteByCode(productCode);
        return "删除成功"+n;
    }

    @DeleteMapping("/deleteByIds")
    public String deleteByIds(List<Integer> ids){
        int n = productInfoService.deleteByIds(ids);
        return "删除成功"+n;
    }*/
}