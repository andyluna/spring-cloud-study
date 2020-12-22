package com.andy.cloud.product.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @time: 2020/12/21 十二月 10:43
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Entity(name = "T_PRODUCT_INFO")
@EntityListeners(AuditingEntityListener.class)
public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    @Column(name = "PRODUCT_CODE", unique = true)
    private String productCode;

    private Double productPrice;

    @CreatedDate
    @Column(updatable = false)
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createLocalDateTime;

    @UpdateTimestamp
    private LocalDateTime updateLocalDateTime;

    public ProductInfo(){

    }

    public ProductInfo(String productName, String productCode, Double productPrice) {
        this.productName = productName;
        this.productCode = productCode;
        this.productPrice = productPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getCreateLocalDateTime() {
        return createLocalDateTime;
    }

    public void setCreateLocalDateTime(LocalDateTime createLocalDateTime) {
        this.createLocalDateTime = createLocalDateTime;
    }

    public LocalDateTime getUpdateLocalDateTime() {
        return updateLocalDateTime;
    }

    public void setUpdateLocalDateTime(LocalDateTime updateLocalDateTime) {
        this.updateLocalDateTime = updateLocalDateTime;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createLocalDateTime=" + createLocalDateTime +
                ", updateLocalDateTime=" + updateLocalDateTime +
                '}';
    }
}
