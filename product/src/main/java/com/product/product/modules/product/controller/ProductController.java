package com.product.product.modules.product.controller;

import com.product.product.modules.product.dto.ProductRequest;
import com.product.product.modules.product.dto.ProductResponse;
import com.product.product.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private ProductRequest productRequest;
    @PostMapping
    @Transactional
    public ProductResponse save(@RequestBody ProductRequest request) {
        ProductRequest productsave1 = new ProductRequest();
        productsave1.setName("Crise nas infinitas terras");
        productsave1.setQuantity_available(10);
        productsave1.setCategoryId(1);
        productsave1.setSupplierId(1);

        ProductRequest productsave2 = new ProductRequest();
        productsave2.setName("Naruto");
        productsave2.setQuantity_available(100);
        productsave2.setCategoryId(2);
        productsave2.setSupplierId(2);

        ProductRequest productsave3 = new ProductRequest();
        productsave3.setName("One Puch Man");
        productsave3.setQuantity_available(200);
        productsave3.setCategoryId(3);
        productsave3.setSupplierId(3);


        productService.save(productsave2);
        productService.save(productsave3);

        return productService.save(request);
    }

}
