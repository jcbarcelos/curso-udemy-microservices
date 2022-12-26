package com.product.product.modules.product.repository;

import com.product.product.modules.product.model.Product;
import com.product.product.modules.product.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
