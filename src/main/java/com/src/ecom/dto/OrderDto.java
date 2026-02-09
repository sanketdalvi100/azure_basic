package com.src.ecom.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class OrderDto {

    private String orderId;
    private String customerEmail;
    private String productId;
    private int quantity;
    private BigDecimal price;
    private String status;
    private Date createdAt;
    private String productName;

    public OrderDto() {
        // Required for Jackson
    }

    public OrderDto(
            String orderId,
            String customerEmail,
            String productId,
            int quantity,
            BigDecimal price,
            String status,
            Date createdAt,
            String productName) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

