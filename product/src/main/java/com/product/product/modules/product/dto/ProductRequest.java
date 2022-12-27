package com.product.product.modules.product.dto;

import com.product.product.modules.category.model.Category;
import com.product.product.modules.supplier.model.Supplier;
import lombok.Data;

@Data
public class ProductRequest {
   private String name;
    private Integer categoryId;
    private Integer supplierId;
    private Integer quantity_available;
}
