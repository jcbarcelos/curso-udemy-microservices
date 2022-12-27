package com.product.product.modules.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.product.modules.category.model.Category;
import com.product.product.modules.supplier.model.Supplier;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {
   private String name;

    @JsonProperty("create_at")
    private LocalDateTime createAt;
    private Integer categoryId;
    private Integer supplierId;
    private Integer quantity_available;
}
