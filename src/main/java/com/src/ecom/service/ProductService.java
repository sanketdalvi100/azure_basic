package com.src.ecom.service;

import com.src.ecom.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProducts();
    Optional<Product> getProductById(String id);
}
