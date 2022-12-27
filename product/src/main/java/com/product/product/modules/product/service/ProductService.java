package com.product.product.modules.product.service;

import com.product.product.config.exception.ValidationException;
import com.product.product.modules.category.model.Category;
import com.product.product.modules.category.repository.CategoryRepository;
import com.product.product.modules.product.dto.ProductRequest;
import com.product.product.modules.product.dto.ProductResponse;
import com.product.product.modules.product.model.Product;
import com.product.product.modules.product.repository.ProductRepository;
import com.product.product.modules.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ProductService {

    private static final Integer ZERO = 0;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public ProductResponse save(ProductRequest productRequest) {
        validateProductDataInformed(productRequest);
        validateProductCategoryAndSupplierInformed(productRequest);
        var category = categoryRepository.findById(productRequest.getCategoryId());
        var supplier = supplierRepository.findById(productRequest.getSupplierId());
        var product = productRepository.save(Product.of(productRequest,  category.get(), supplier.get()));
        return ProductResponse.of(product);
    }


    private void validateProductDataInformed(ProductRequest productRequest) {
        if (isEmpty(productRequest.getName())) {
            throw new ValidationException("The product name was not informed.");
        }
        if (isEmpty(productRequest.getQuantity_available())) {
            throw new ValidationException("The product Quantity available was not informed.");
        }
        if (productRequest.getQuantity_available() <= ZERO) {
            throw new ValidationException("The product Quantity should not be less or equal to zero.");
        }
    }

    private void validateProductCategoryAndSupplierInformed(ProductRequest productRequest) {

        if (isEmpty(productRequest.getCategoryId())) {
            throw new ValidationException("The product category was not informed.");
        }
        if (isEmpty(productRequest.getSupplierId())) {
            throw new ValidationException("The product supplier  was not informed.");
        }
    }
}
