package com.spring.productapi.productapi.modules.supplier.controller;

import com.spring.productapi.productapi.config.exception.SuccessResponse;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierRequest;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierResponse;
import com.spring.productapi.productapi.modules.supplier.service.SupplierService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    @Transactional
    public SupplierResponse save(@RequestBody SupplierRequest request) {

        return supplierService.save(request);
    }

    @GetMapping()
    public List<SupplierResponse> findA() {
        return supplierService.findAll();
    }

    @GetMapping("{id}")
    public SupplierResponse findById(@PathVariable Integer id) {
        return supplierService.findByIdResponse(id);
    }

    @GetMapping("name/{name}")
    public List<SupplierResponse> findByName(@PathVariable String name) {
        return supplierService.findByNameIgnoreCaseContaining(name);
    }

    @DeleteMapping("{id}")
    public SuccessResponse delete(@PathVariable Integer id) {
        return supplierService.delete(id);
    }

    @PutMapping("{id}")
    public SupplierResponse update(@RequestBody SupplierRequest request, @PathVariable Integer id) {
        return supplierService.update(request, id);
    }

}
