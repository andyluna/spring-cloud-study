package com.andy.cloud.product.service.impl;

import com.andy.cloud.product.entity.ProductInfo;
import com.andy.cloud.product.repository.ProductInfoRepository;
import com.andy.cloud.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @time: 2020/12/22 十二月 09:18
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Service
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo getById(Integer id) {
        return productInfoRepository.findById(id).orElse(null);
    }

    @Override
    public ProductInfo getByProductCode(String productCode) {
        return productInfoRepository.findByProductCode(productCode);
    }

    @Override
    public List<ProductInfo> getAll(List<Integer> ids) {
        List<ProductInfo> list = null;
        if(ids==null){
            list = productInfoRepository.findAll();
        }else{
            list = productInfoRepository.findAllById(ids);
        }
        return list;
    }

    @Override
    public ProductInfo saveProduct(String productName, String productCode, Double productPrice) {
        ProductInfo info = new ProductInfo(productName, productCode, productPrice);
        ProductInfo save = productInfoRepository.save(info);
        return info;
    }

    @Override
    public ProductInfo saveProduct(ProductInfo productInfo) {
        productInfoRepository.save(productInfo);
        return productInfo;
    }

    @Override
    public ProductInfo updateProduct(Integer id, String productName, String productCode, Double productPrice) {
        ProductInfo one = productInfoRepository.getOne(id);
        if(one!=null){
            one.setProductName(productName);
            one.setProductCode(productCode);
            one.setProductPrice(productPrice);
        }
        return one;
    }

    @Override
    public ProductInfo updateProduct(ProductInfo productInfo) {
        ProductInfo one = productInfoRepository.getOne(productInfo.getId());
        if(one!=null){
            one.setProductName(productInfo.getProductName());
            one.setProductCode(productInfo.getProductCode());
            one.setProductPrice(productInfo.getProductPrice());
        }
        return one;
    }

    @Override
    public int deleteById(Integer id) {
        int n = productInfoRepository.deleteProductInfoById(id);
        return n;
    }

    @Override
    public int deleteByCode(String productCode) {
        int n = productInfoRepository.deleteProductInfoByProductCode(productCode);
        return n;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        int n = productInfoRepository.deleteAllByIdIn(ids);
        return n;
    }
}
