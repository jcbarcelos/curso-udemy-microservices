package com.product.product.modules.product.model;

import com.product.product.config.exception.EntityWithUUID;
import com.product.product.modules.product.dto.CategoryRequest;
import com.product.product.modules.product.dto.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;
import org.springframework.beans.BeanUtils;

@Data
@Table(name = "Category")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends EntityWithUUID {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

     public static Category of(CategoryRequest categoryRequest) {
        var category = new Category();
        BeanUtils.copyProperties(categoryRequest, category);
        return category;
    }
}

