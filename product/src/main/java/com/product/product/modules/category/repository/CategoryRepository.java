package com.product.product.modules.category.repository;


import com.product.product.modules.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
