package com.src.ecom.controller;

import com.src.ecom.model.Product;
import com.src.ecom.service.AzureBlobService;
import com.src.ecom.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final AzureBlobService azureBlobService;

    public ProductController(ProductService service, AzureBlobService azureBlobService) {
        this.service = service;
        this.azureBlobService = azureBlobService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", service.getProducts());
        return "product-list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable String id, Model model) {
        Product product = service.getProductById(id).get();
        String imageUrl = azureBlobService.generateSasUrl(product.getImageUrl());
        product.setImageUrl(imageUrl);
        model.addAttribute("product", product);
        return "product-detail";
    }

}
