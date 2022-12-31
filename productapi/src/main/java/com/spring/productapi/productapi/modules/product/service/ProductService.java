package com.spring.productapi.productapi.modules.product.service;

import com.spring.productapi.productapi.config.exception.SuccessResponse;
import com.spring.productapi.productapi.config.exception.ValidationException;
import com.spring.productapi.productapi.modules.category.model.Category;
import com.spring.productapi.productapi.modules.category.service.CategoryService;
import com.spring.productapi.productapi.modules.product.dto.ProductRequest;
import com.spring.productapi.productapi.modules.product.dto.ProductResponse;
import com.spring.productapi.productapi.modules.product.model.Product;
import com.spring.productapi.productapi.modules.product.repository.ProductRepository;
import com.spring.productapi.productapi.modules.supplier.model.Supplier;
import com.spring.productapi.productapi.modules.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ProductService {
  private static final Integer ZERO = 0;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private SupplierService supplierService;

  public Product findById(Integer idProduct) {
    return productRepository
      .findById(idProduct)
      .orElseThrow(
        () -> new ValidationException("There's no supplier for the given ID.")
      );
  }

  public List<ProductResponse> findByCategoryId(Integer idCategory) {
    if (isEmpty(idCategory)) {
      throw new ValidationException("The category id must be informed.");
    }
    return productRepository
      .findByCategoryId(idCategory)
      .stream()
      .map(ProductResponse::of)
      .collect(Collectors.toList());
  }

  public List<ProductResponse> findBySupplierId(Integer idSupplier) {
    if (isEmpty(idSupplier)) {
      throw new ValidationException("The category id must be informed.");
    }
    return productRepository
      .findBySupplierId(idSupplier)
      .stream()
      .map(ProductResponse::of)
      .collect(Collectors.toList());
  }

  public ProductResponse findByIdResponse(Integer idProduct) {
    if (isEmpty(idProduct)) {
      throw new ValidationException("The category ID must be informed.");
    }
    return ProductResponse.of(findById(idProduct));
  }

  public List<ProductResponse> findAll() {
    return productRepository
      .findAll()
      .stream()
      .map(ProductResponse::of)
      .collect(Collectors.toList());
  }

  public List<ProductResponse> findByNameIgnoreCaseContaining(
    @PathVariable String name
  ) {
    if (isEmpty(name)) {
      throw new ValidationException("The category name must be informed.");
    }
    return productRepository
      .findByNameIgnoreCaseContaining(name)
      .stream()
      .map(ProductResponse::of)
      .collect(Collectors.toList());
  }

  public Boolean existsSupplierId(Integer supplierId) {
    return productRepository.existsBySupplierId(supplierId);
  }

  public Boolean existsCategoryId(Integer categoryId) {
    return productRepository.existsByCategoryId(categoryId);
  }

  public ProductResponse save(ProductRequest productRequest) {
    validateProductDataInformed(productRequest);
    validateProductCategoryAndSupplierInformed(productRequest);
    Category category = categoryService.findById(productRequest.getCategoryId());
    Supplier supplier = supplierService.findById(productRequest.getSupplierId());
    Product product = productRepository.save(
      Product.of(productRequest, category, supplier)
    );
    return ProductResponse.of(product);
  }

  public SuccessResponse delete(Integer id) {
    validationInformedId(id);
    productRepository.deleteById(id);
    return SuccessResponse.create("The product was deleted");
  }

  public ProductResponse update(ProductRequest productRequest, Integer id) {
    validateProductDataInformed(productRequest);
    validationInformedId(id);
    validateProductCategoryAndSupplierInformed(productRequest);
    Category category = categoryService.findById(productRequest.getCategoryId());
    Supplier supplier = supplierService.findById(productRequest.getSupplierId());
    Product product = Product.of(productRequest, category, supplier);
    product.setId(id);
    productRepository.save(product);
    return ProductResponse.of(product);
  }

  private void validateProductDataInformed(ProductRequest productRequest) {
    if (isEmpty(productRequest.getName())) {
      throw new ValidationException("The product name was not informed.");
    }
    if (isEmpty(productRequest.getQuantity_available())) {
      throw new ValidationException(
        "The product Quantity available was not informed."
      );
    }
    if (productRequest.getQuantity_available() <= ZERO) {
      throw new ValidationException(
        "The product Quantity should not be less or equal to zero."
      );
    }
  }

  private void validateProductCategoryAndSupplierInformed(
    ProductRequest productRequest
  ) {
    if (isEmpty(productRequest.getCategoryId())) {
      throw new ValidationException("The product category was not informed.");
    }
    if (isEmpty(productRequest.getSupplierId())) {
      throw new ValidationException("The product supplier  was not informed.");
    }
  }

  private void validationInformedId(Integer id) {
    if (isEmpty(id)) {
      throw new ValidationException("The supplier id must be informed.");
    }
  }
}
