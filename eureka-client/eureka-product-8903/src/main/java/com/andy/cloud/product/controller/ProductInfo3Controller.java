package com.andy.cloud.product.controller;

import com.andy.cloud.product.entity.ProductInfo;
import com.andy.cloud.product.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @time: 2020/12/22 十二月 09:20
 * @author: xiangdan/xiangdan@dtxytech.com
 */

@RestController
@RequestMapping("/productinfo")
@Slf4j
public class ProductInfo3Controller {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/{id}")
    public ProductInfo getById(@PathVariable("id") Integer id){
        ProductInfo info = productInfoService.getById(id);
        return info;
    }

    @GetMapping("/getByCode")
    public ProductInfo getByCode(String productCode){
        ProductInfo info = productInfoService.getByProductCode(productCode);
        return info;
    }

    @GetMapping("/getAllByIds")
    public List<ProductInfo> getAllByIds(@RequestParam("ids") List<Integer> ids){
        List<ProductInfo> infos = productInfoService.getAll(ids);
        return infos;
    }


    @PostMapping("/save")
    public ProductInfo save(@RequestBody ProductInfo productInfo){
        productInfoService.saveProduct(productInfo);
        return productInfo;
    }


    @PostMapping("/update")
    public ProductInfo update(@RequestBody ProductInfo productInfo){
        ProductInfo info = productInfoService.updateProduct(productInfo);
        return productInfo;
    }


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
    public String deleteByIds(@RequestParam("ids") List<Integer> ids){
        int n = productInfoService.deleteByIds(ids);
        return "删除成功"+n;
    }
}
