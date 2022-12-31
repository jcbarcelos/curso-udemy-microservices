package com.spring.productapi.productapi.modules.product.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.productapi.productapi.modules.category.dto.CategoryResponse;
import com.spring.productapi.productapi.modules.product.model.Product;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    @JsonProperty("create_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createAt;
    private CategoryResponse category;
    private SupplierResponse supplier;
    private Integer quantity_available;


    public static ProductResponse of(Product product) {

        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .createAt(product.getCreateAt())
                .quantity_available(product.getQuantity_available())
                .category(CategoryResponse.of(product.getCategory()))
                .supplier(SupplierResponse.of(product.getSupplier()))
                .build();
    }

}
