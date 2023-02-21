package com.dphone.BuyingDetails.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Buy_Details")
public class BuyDetails {

    @Id
    @Column(name="userId")
    private Long userId;

    @Column(name="productName")
    private String productName;

    @Column(name="purchaseDate")
    private Date purchaseDate;

    @Column(name="customerId")
    private Long customerId;

    public BuyDetails(long userId, String productName, Date purchaseDate, Long customerId) {
        this.userId=userId;
        this.productName=productName;
        this.purchaseDate=purchaseDate;
        this.customerId=customerId;

    }

    public BuyDetails() {

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

