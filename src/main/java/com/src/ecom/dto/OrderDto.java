package com.src.ecom.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderDto {

    private String orderId;
    private String customerId;
    private String productId;
    private int quantity;
    private BigDecimal price;
    private String status;
    private Instant createdAt;

    public OrderDto() {
        // Required for Jackson
    }

    public OrderDto(
            String orderId,
            String customerId,
            String productId,
            int quantity,
            BigDecimal price,
            String status,
            Instant createdAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}

