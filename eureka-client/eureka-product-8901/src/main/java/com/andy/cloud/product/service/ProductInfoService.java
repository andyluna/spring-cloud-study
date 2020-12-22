package com.andy.cloud.product.service;

import com.andy.cloud.product.entity.ProductInfo;

import java.util.List;

/**
 * @time: 2020/12/22 十二月 09:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
public interface ProductInfoService {


    ProductInfo getById(Integer id);

    ProductInfo getByProductCode(String productCode);

    List<ProductInfo> getAll(List<Integer> ids);

    ProductInfo saveProduct(String productName,String productCode,Double productPrice);

    ProductInfo saveProduct(ProductInfo productInfo);

    ProductInfo updateProduct(Integer id,String productName,String productCode,Double productPrice);

    ProductInfo updateProduct(ProductInfo productInfo);


    int deleteById(Integer id);

    int deleteByCode(String productCode);

    int deleteByIds(List<Integer> ids);




}
