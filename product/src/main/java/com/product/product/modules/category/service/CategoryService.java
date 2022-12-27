package com.product.product.modules.category.service;

import com.product.product.config.exception.ValidationException;
import com.product.product.modules.category.dto.CategoryRequest;
import com.product.product.modules.category.dto.CategoryResponse;
import com.product.product.modules.category.model.Category;
import com.product.product.modules.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }

    public CategoryResponse save(CategoryRequest categoryRequest) {
        validateCategoryNameInformed(categoryRequest);
        var category = categoryRepository.saveAndFlush(Category.of(categoryRequest));
        return CategoryResponse.of(category);
    }

    private void validateCategoryNameInformed(CategoryRequest categoryRequest) {
        if (isEmpty(categoryRequest.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}
