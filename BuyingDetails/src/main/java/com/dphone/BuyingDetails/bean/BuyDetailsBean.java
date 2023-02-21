package com.dphone.BuyingDetails.bean;

import javax.xml.crypto.Data;
import java.util.Date;

public class BuyDetailsBean {
    private Long userId;
    private String productName;
    private Date purchaseDate;
    private Long customerId;

    public BuyDetailsBean(long userId, String productName, Date purchaseDate, Long customerId) {
        this.userId=userId;
        this.productName=productName;
        this.purchaseDate=purchaseDate;
        this.customerId=customerId;

    }
    public BuyDetailsBean() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "BuyDetails{" +
                "userId=" + userId +
                ", productName='" + productName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", customerId=" + customerId +
                '}';
    }
}


