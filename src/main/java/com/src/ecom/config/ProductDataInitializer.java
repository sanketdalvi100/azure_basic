package com.src.ecom.config;

import com.src.ecom.model.Product;
import com.src.ecom.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductDataInitializer {
    private final ProductRepository productRepository;

    public ProductDataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initProducts() {
        if (productRepository.count() > 0) {
            return; // Don't insert again on restart
        }
        List<Product> products = List.of(
                new Product( "iPhone 15",  new BigDecimal("79999"),
                        "https://images.unsplash.com/photo-1513708927688-890a98c6a77d"),

                new Product( "Samsung S24", new BigDecimal("74999"),
                        "https://images.unsplash.com/photo-1513708927688-890a98c6a77d"),

                new Product( "Pixel 9",  new BigDecimal("69999"),
                        "https://images.unsplash.com/photo-1513708927688-890a98c6a77d")
        );

        productRepository.saveAll(products);
        System.out.println("✅ Sample products inserted into DB");
    }
}
