package com.spring.productapi.productapi.modules.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
