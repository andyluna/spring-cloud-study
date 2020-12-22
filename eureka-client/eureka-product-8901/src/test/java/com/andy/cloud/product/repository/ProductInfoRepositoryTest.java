package com.andy.cloud.product.repository;

import com.andy.cloud.product.EurekaProduct8901Test;
import com.andy.cloud.product.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @time: 2020/12/21 十二月 10:59
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
class ProductInfoRepositoryTest extends EurekaProduct8901Test {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testGet(){
        Optional<ProductInfo> id = productInfoRepository.findById(1);
        Assertions.assertNotNull(id.get());
        log.info("productInfo:{}",id.get());
    }

    @Test
    public void testSave(){
        ProductInfo pi = new ProductInfo();
        pi.setProductCode("10013");
        pi.setProductName("针织衫3");
        pi.setProductPrice(123.45d);
        productInfoRepository.save(pi);
    }

    @Test
    public void testUpdate(){
        Optional<ProductInfo> productInfo = productInfoRepository.findById(1);
        ProductInfo info = productInfo.get();
        info.setProductName(info.getProductName()+new Random().nextInt(10));
        productInfoRepository.save(info);
    }

}