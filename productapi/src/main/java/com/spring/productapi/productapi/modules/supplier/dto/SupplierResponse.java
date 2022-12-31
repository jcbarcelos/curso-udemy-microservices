package com.spring.productapi.productapi.modules.supplier.dto;


import com.spring.productapi.productapi.modules.supplier.model.Supplier;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SupplierResponse {
    private int id;
    private String name;

    public static SupplierResponse of(Supplier supplier) {
        SupplierResponse response = new SupplierResponse();
        BeanUtils.copyProperties(supplier, response);
        return response;
    }
}
