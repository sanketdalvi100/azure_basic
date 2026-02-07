package com.src.ecom.service;

import com.src.ecom.model.Product;
import com.src.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository prodRepo;
    ProductServiceImpl(ProductRepository prodRepo){
        this.prodRepo = prodRepo;
    }
    @Override
    public List<Product> getProducts() {
        return prodRepo.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return prodRepo.findById(id);
    }
}
