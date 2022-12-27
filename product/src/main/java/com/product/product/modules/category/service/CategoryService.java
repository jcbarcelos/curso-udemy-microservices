package com.product.product.modules.category.service;

import com.product.product.config.exception.ValidationException;
import com.product.product.modules.category.dto.CategoryRequest;
import com.product.product.modules.category.dto.CategoryResponse;
import com.product.product.modules.category.model.Category;
import com.product.product.modules.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category findById(Integer idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }

    public CategoryResponse findByIdResponse(Integer idCategory) {
        if (isEmpty(idCategory)) {
            throw new ValidationException("The category ID must be informed.");
        }
        return CategoryResponse.of(findById(idCategory));
    }

    public CategoryResponse save(CategoryRequest categoryRequest) {
        validateCategoryNameInformed(categoryRequest);
        var category = categoryRepository.saveAndFlush(Category.of(categoryRequest));
        return CategoryResponse.of(category);
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByDescription(@PathVariable String description) {
        if (isEmpty(description)) {
            throw new ValidationException("The category description must be informed.");
        }
        return categoryRepository.findByDescriptionIgnoreCaseContaining(description)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    private void validateCategoryNameInformed(CategoryRequest categoryRequest) {
        if (isEmpty(categoryRequest.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}
