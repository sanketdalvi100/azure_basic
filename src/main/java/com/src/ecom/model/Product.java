package com.src.ecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends Parent{
    private String name;
    private BigDecimal price;
    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;
}
