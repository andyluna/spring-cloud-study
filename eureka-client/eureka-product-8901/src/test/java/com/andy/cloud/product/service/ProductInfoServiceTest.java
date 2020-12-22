package com.andy.cloud.product.service;

import com.andy.cloud.product.EurekaProduct8901Test;
import com.andy.cloud.product.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @time: 2020/12/22 十二月 09:40
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
class ProductInfoServiceTest extends EurekaProduct8901Test {

    @Autowired
    private ProductInfoService productInfoService;
    @Test
    void getById() {
        ProductInfo info = productInfoService.getById(1);
        log.info("查询结果{}",info);
    }

    @Test
    void getByProductCode() {
        ProductInfo info = productInfoService.getByProductCode("10001");
        log.info("查询结果{}",info);
    }

    @Test
    void getAll() {
        List<ProductInfo> list = productInfoService.getAll(null);
        log.info("查询结果{}",list.size());
        list.forEach(p->{
            log.info("{}",p);
        });
    }

    @Test
    void saveProduct() {
        ProductInfo info = productInfoService.saveProduct("测试", "T0001", 234.56d);
        log.info("保存结果{}",info);
    }

    @Test
    void updateProduct() {
        ProductInfo info = productInfoService.updateProduct(13,"测试修改", "T0001", 234.56d);
        log.info("保存结果{}",info);
    }

    @Test
    void deleteById() {
        productInfoService.deleteById(13);
        log.info("删除成功");
    }

    @Test
    void deleteByCode() {
        int n = productInfoService.deleteByCode("10013");
        log.info("删除成功{}",n);
    }

    @Test
    void deleteByIds() {
        List<Integer> ids = Arrays.asList(2,3,4,5,6,7);
        int n = productInfoService.deleteByIds(ids);
        log.info("删除成功{}",n);
    }
}