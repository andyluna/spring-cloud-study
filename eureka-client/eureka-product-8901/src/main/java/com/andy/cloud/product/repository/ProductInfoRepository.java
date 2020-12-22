package com.andy.cloud.product.repository;

import com.andy.cloud.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @time: 2020/12/21 十二月 10:46
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,Integer> {


    ProductInfo findByProductCode(String productCode);


    int deleteProductInfoById(Integer id);

    int deleteAllByIdIn(List<Integer> id);


    int deleteProductInfoByProductCode(String productCode);

}
