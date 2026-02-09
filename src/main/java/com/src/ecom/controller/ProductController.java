package com.src.ecom.controller;

import com.src.ecom.dto.OrderDto;
import com.src.ecom.model.Product;
import com.src.ecom.service.AzureBlobService;
import com.src.ecom.service.OrderEventPublisher;
import com.src.ecom.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final AzureBlobService azureBlobService;
    private final OrderEventPublisher orderEventPublisher;

    public ProductController(ProductService service, AzureBlobService azureBlobService, OrderEventPublisher orderEventPublisher) {
        this.service = service;
        this.azureBlobService = azureBlobService;
        this.orderEventPublisher = orderEventPublisher;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", service.getProducts());
        return "product-list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        System.out.println("Detail : "+id);
        Product product = service.getProductById(id).get();
        String imageUrl = azureBlobService.generateSasUrl(product.getImageUrl());
        product.setImageUrl(imageUrl);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @PostMapping("/buy/{id}")
    public String buyNow(@PathVariable String id, Model model) {
        System.out.println(id);
        Product product = service.getProductById(id).get();
        System.out.println("buy now : "+product);
        model.addAttribute("product", product);
        return "checkout"; // thymeleaf page
    }

    @PostMapping("/checkout/place-order")
    public String placeOrder(
            @RequestParam String productId,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam String pincode,
            Model model
    ) throws Exception {
        System.out.println(productId);
        Product product = service.getProductById(productId).get();
        model.addAttribute("product", product);
        model.addAttribute("customerName", name);
        OrderDto dto = new OrderDto();
        dto.setCreatedAt(new Date());
        dto.setProductId(product.getId());
        dto.setPrice(product.getPrice());
        orderEventPublisher.publishOrder(dto);
        return "order-success";
    }


}
