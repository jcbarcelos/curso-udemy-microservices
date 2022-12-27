package com.product.product;

import com.product.product.modules.category.dto.CategoryRequest;
import com.product.product.modules.category.service.CategoryService;
import com.product.product.modules.product.dto.ProductRequest;
import com.product.product.modules.product.service.ProductService;
import com.product.product.modules.supplier.dto.SupplierRequest;
import com.product.product.modules.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/seed")
public class SeedsController {

    @Autowired
    private ProductService productService;

    private ProductRequest productRequest;

    @Autowired
    private CategoryService categoryService;
    private CategoryRequest categoryRequest;

    @Autowired
    private SupplierService supplierService;

    private SupplierRequest supplierRequest;
    @PostMapping()
    public ResponseEntity<HashMap<String, Object>> getApiStatus() {
        CategoryRequest categorysave1 = new CategoryRequest();
        CategoryRequest categorysave2 = new CategoryRequest();
        CategoryRequest categorysave3 = new CategoryRequest();
        categorysave1.setDescription("Comic Books");
        categorysave2.setDescription("Movies");
        categorysave3.setDescription("Books");
        categoryService.save(categorysave1);
        categoryService.save(categorysave2);
        categoryService.save(categorysave3);

        SupplierRequest suppliersave1 = new SupplierRequest();
        SupplierRequest suppliersave2 = new SupplierRequest();
        SupplierRequest suppliersave3 = new SupplierRequest();
        suppliersave1.setName("Panini Comics");
        suppliersave2.setName("Amazon");
        suppliersave3.setName("Livraria Online");
        supplierService.save(suppliersave1);
        supplierService.save(suppliersave2);
        supplierService.save(suppliersave3);

        ProductRequest productsave1 = new ProductRequest();
        productsave1.setName("Crise nas infinitas terras");
        productsave1.setQuantity_available(10);
        productsave1.setCategoryId(1);
        productsave1.setSupplierId(1);

        ProductRequest productsave2 = new ProductRequest();
        productsave2.setName("Naruto");
        productsave2.setQuantity_available(100);
        productsave2.setCategoryId(2);
        productsave2.setSupplierId(2);

        ProductRequest productsave3 = new ProductRequest();
        productsave3.setName("One Puch Man");
        productsave3.setQuantity_available(200);
        productsave3.setCategoryId(3);
        productsave3.setSupplierId(3);

        productService.save(productsave1);
        productService.save(productsave2);
        productService.save(productsave3);
        return ResponseEntity.ok().build();
    }
}
