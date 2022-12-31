package com.spring.productapi.productapi.modules.category.service;

import com.spring.productapi.productapi.config.exception.SuccessResponse;
import com.spring.productapi.productapi.config.exception.ValidationException;
import com.spring.productapi.productapi.modules.category.dto.CategoryRequest;
import com.spring.productapi.productapi.modules.category.dto.CategoryResponse;
import com.spring.productapi.productapi.modules.category.model.Category;
import com.spring.productapi.productapi.modules.category.repository.CategoryRepository;
import com.spring.productapi.productapi.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class CategoryService {

  @Autowired  
  private CategoryRepository categoryRepository;


  private ProductService productService;

  public Category findById(Integer idCategory) {
    return categoryRepository
      .findById(idCategory)
      .orElseThrow(
        () -> new ValidationException("There's no supplier for the given ID.")
      );
  }

  public CategoryResponse findByIdResponse(Integer idCategory) {
    if (isEmpty(idCategory)) {
      throw new ValidationException("The category ID must be informed.");
    }
    return CategoryResponse.of(findById(idCategory));
  }

  public List<CategoryResponse> findAll() {
    return categoryRepository
      .findAll()
      .stream()
      .map(CategoryResponse::of)
      .collect(Collectors.toList());
  }

  public List<CategoryResponse> findByDescription(
    @PathVariable String description
  ) {
    if (isEmpty(description)) {
      throw new ValidationException(
        "The category description must be informed."
      );
    }
    return categoryRepository
      .findByDescriptionIgnoreCaseContaining(description)
      .stream()
      .map(CategoryResponse::of)
      .collect(Collectors.toList());
  }

  public CategoryResponse save(CategoryRequest categoryRequest) {
    validateCategoryNameInformed(categoryRequest);
    Category category = categoryRepository.save(
      Category.of(categoryRequest)
    );
    return CategoryResponse.of(category);
  }

  public SuccessResponse delete(Integer id) {
    validationInformedId(id);
    if (productService.existsCategoryId(id)) {
      throw new ValidationException(
        "You cannot delete this category because it's already defined by a product"
      );
    }
    categoryRepository.deleteById(id);
    return SuccessResponse.create("The suppllier was deleted");
  }

  public CategoryResponse update(CategoryRequest categoryRequest, Integer id) {
    validateCategoryNameInformed(categoryRequest);
    validationInformedId(id);
    Category category = Category.of(categoryRequest);
    category.setId(id);
    categoryRepository.save(category);
    return CategoryResponse.of(category);
  }

  private void validateCategoryNameInformed(CategoryRequest categoryRequest) {
    if (isEmpty(categoryRequest.getDescription())) {
      throw new ValidationException(
        "The category description was not informed."
      );
    }
  }

  private void validationInformedId(Integer id) {
    if (isEmpty(id)) {
      throw new ValidationException("The category id must be informed.");
    }
  }
}
