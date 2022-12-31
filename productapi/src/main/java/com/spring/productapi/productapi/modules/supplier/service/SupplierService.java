package com.spring.productapi.productapi.modules.supplier.service;

import com.spring.productapi.productapi.config.exception.SuccessResponse;
import com.spring.productapi.productapi.config.exception.ValidationException;
import com.spring.productapi.productapi.modules.product.service.ProductService;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierRequest;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierResponse;
import com.spring.productapi.productapi.modules.supplier.model.Supplier;
import com.spring.productapi.productapi.modules.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class SupplierService {

  @Autowired
  private SupplierRepository supplierRepository;


  private ProductService productService;

  public Supplier findById(Integer idSupplier) {
    return supplierRepository
      .findById(idSupplier)
      .orElseThrow(
        () -> new ValidationException("There's no supplier for the given ID.")
      );
  }

  public SupplierResponse findByIdResponse(Integer idCategory) {
    validationInformedId(idCategory);
    return SupplierResponse.of(findById(idCategory));
  }

  public List<SupplierResponse> findAll() {
    return supplierRepository
      .findAll()
      .stream()
      .map(SupplierResponse::of)
      .collect(Collectors.toList());
  }

  public List<SupplierResponse> findByNameIgnoreCaseContaining(
    @PathVariable String description
  ) {
    if (isEmpty(description)) {
      throw new ValidationException(
        "The category description must be informed."
      );
    }
    return supplierRepository
      .findByNameIgnoreCaseContaining(description)
      .stream()
      .map(SupplierResponse::of)
      .collect(Collectors.toList());
  }

  public SupplierResponse save(SupplierRequest supplierRequest) {
    validateSupplierNameInformed(supplierRequest);
    Supplier supplier = supplierRepository.save(
      Supplier.of(supplierRequest)
    );
    return SupplierResponse.of(supplier);
  }

  public SupplierResponse update(SupplierRequest supplierRequest, Integer id) {
    validateSupplierNameInformed(supplierRequest);
    validationInformedId(id);
    Supplier supplier = Supplier.of(supplierRequest);
    supplier.setId(id);
    supplierRepository.save(supplier);
    return SupplierResponse.of(supplier);
  }

  public SuccessResponse delete(Integer id) {
    validationInformedId(id);
    if (productService.existsSupplierId(id)) {
      throw new ValidationException(
        "You cannot delete this supplier because it's already defined by a product"
      );
    }
    supplierRepository.deleteById(id);
    return SuccessResponse.create("The suppllier was deleted");
  }

  private void validateSupplierNameInformed(SupplierRequest supplierRequest) {
    if (isEmpty(supplierRequest.getName())) {
      throw new ValidationException("The supplier name was not informed.");
    }
  }

  private void validationInformedId(Integer id) {
    if (isEmpty(id)) {
      throw new ValidationException("The supplier id must be informed.");
    }
  }
}
