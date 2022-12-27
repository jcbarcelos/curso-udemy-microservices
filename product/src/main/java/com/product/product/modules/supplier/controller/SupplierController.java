package com.product.product.modules.supplier.controller;

import com.product.product.modules.supplier.dto.SupplierRequest;
import com.product.product.modules.supplier.dto.SupplierResponse;
import com.product.product.modules.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    private SupplierRequest supplierRequest;
    @PostMapping
    @Transactional
    public SupplierResponse save(@RequestBody SupplierRequest request) {
        SupplierRequest suppliersave1 = new SupplierRequest();
        SupplierRequest suppliersave2 = new SupplierRequest();
        SupplierRequest suppliersave3 = new SupplierRequest();
        suppliersave1.setName("Panini Comics");
        suppliersave2.setName("Amazon");
        suppliersave3.setName("Livraria Online");
        supplierService.save(suppliersave1);
        supplierService.save(suppliersave2);
        return supplierService.save(suppliersave3);
    }

}
