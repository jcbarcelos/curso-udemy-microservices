package com.product.product.modules.product.model;


import com.product.product.config.exception.EntityWithUUID;
import com.product.product.modules.category.model.Category;
import com.product.product.modules.product.dto.ProductRequest;
import com.product.product.modules.supplier.model.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@Table(name = "Product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends EntityWithUUID {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_category", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "fk_supplier", nullable = false)
    private Supplier supplier;

    @Column(name = "quantity_available", nullable = false)
    private Integer quantity_available;
    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @PrePersist
    public void prePersist(){
        createAt = LocalDateTime.now();
    }
    public static Product of(ProductRequest categoryRequest,
                             Category category,
                             Supplier supplier) {
        return Product
                .builder()
                .name(categoryRequest.getName())
                .quantity_available(categoryRequest.getQuantity_available())
                .category(category)
                .supplier(supplier)
                .build();
    }
}
