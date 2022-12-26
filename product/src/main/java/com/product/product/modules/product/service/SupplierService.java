package com.product.product.modules.product.service;

import com.product.product.config.exception.ValidationException;
import com.product.product.modules.product.dto.SupplierRequest;
import com.product.product.modules.product.dto.SupplierResponse;
import com.product.product.modules.product.model.Supplier;
import com.product.product.modules.product.repository.SupplierRepository;
import com.product.product.modules.product.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierResponse save(SupplierRequest supplierRequest) {
        validateSupplierNameInformed(supplierRequest);
        var supplier = supplierRepository.saveAndFlush(Supplier.of(supplierRequest));
        return SupplierResponse.of(supplier);
    }

    private void validateSupplierNameInformed(SupplierRequest supplierRequest){
        if(isEmpty(supplierRequest.getName())){
            throw new ValidationException("The supplier name was not informed.");
        }
    }
}
