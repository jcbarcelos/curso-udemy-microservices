package com.spring.productapi.productapi.modules.product.controller;

import com.spring.productapi.productapi.config.exception.SuccessResponse;
import com.spring.productapi.productapi.modules.product.dto.ProductRequest;
import com.spring.productapi.productapi.modules.product.dto.ProductResponse;
import com.spring.productapi.productapi.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping
  @Transactional
  public ProductResponse save(@RequestBody ProductRequest request) {
    return productService.save(request);
  }

  @GetMapping
  public List<ProductResponse> findA() {
    return productService.findAll();
  }

  @GetMapping("{id}")
  public ProductResponse findById(@PathVariable Integer id) {
    return productService.findByIdResponse(id);
  }

  @GetMapping("name/{name}")
  public List<ProductResponse> findByNameIgnoreCaseContaining(
    @PathVariable String name
  ) {
    return productService.findByNameIgnoreCaseContaining(name);
  }

  @GetMapping("category/{categoryId}")
  public List<ProductResponse> findByCategoryId(
    @PathVariable Integer categoryId
  ) {
    return productService.findByCategoryId(categoryId);
  }

  @GetMapping("supplier/{supplierId}")
  public List<ProductResponse> findBySupplierId(
    @PathVariable Integer supplierId
  ) {
    return productService.findBySupplierId(supplierId);
  }

  @PutMapping("{id}")
  public ProductResponse update(
    @RequestBody ProductRequest productRequest,
    @PathVariable Integer id
  ) {
    return productService.update(productRequest, id);
  }

  @DeleteMapping("{id}")
  public SuccessResponse delete(@PathVariable Integer id) {
    return productService.delete(id);
  }
}
