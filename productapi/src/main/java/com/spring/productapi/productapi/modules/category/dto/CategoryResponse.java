package com.spring.productapi.productapi.modules.category.dto;



import com.spring.productapi.productapi.modules.category.model.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CategoryResponse {
    private int id;
    private String description;

    public static CategoryResponse of(Category category) {
        CategoryResponse response = new CategoryResponse();
        BeanUtils.copyProperties(category, response);
        return response;
    }
}
