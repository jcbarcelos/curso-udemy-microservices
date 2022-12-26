package com.product.product.modules.product.dto;


import com.product.product.modules.product.model.Category;
import com.product.product.modules.product.model.Supplier;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SupplierResponse {
    private int id;
    private String name;

    public static SupplierResponse of(Supplier supplier) {
        var response = new SupplierResponse();
        BeanUtils.copyProperties(supplier, response);
        return response;
    }
}
