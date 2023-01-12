package com.spring.productapi.productapi.modules.product.repository;

import com.spring.productapi.productapi.modules.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameIgnoreCaseContaining(String name);
    List<Product> findByCategoryId(Integer id);
    List<Product> findBySupplierId(Integer id);
    Boolean existsBySupplierId(Integer supplierId);
    Boolean existsByCategoryId(Integer categoryId);
}