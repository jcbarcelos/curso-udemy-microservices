package com.spring.productapi.productapi;

import com.spring.productapi.productapi.modules.category.dto.CategoryRequest;
import com.spring.productapi.productapi.modules.category.dto.CategoryResponse;
import com.spring.productapi.productapi.modules.category.service.CategoryService;
import com.spring.productapi.productapi.modules.product.dto.ProductRequest;
import com.spring.productapi.productapi.modules.product.dto.ProductResponse;
import com.spring.productapi.productapi.modules.product.service.ProductService;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierRequest;
import com.spring.productapi.productapi.modules.supplier.dto.SupplierResponse;
import com.spring.productapi.productapi.modules.supplier.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class ProductapiApplication {

    private static final Logger log = LoggerFactory.getLogger(
            ProductapiApplication.class
    );

    public static void main(String[] args) {
        SpringApplication.run(ProductapiApplication.class, args);
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    private ProductRequest productRequest;
    private CategoryRequest categoryRequest;
    private SupplierRequest supplierRequest;

    @Bean
    public CommandLineRunner demo() {
        return args -> {

            CategoryRequest categorysave1 = new CategoryRequest();
            categorysave1.setDescription("Comic Books");
            CategoryResponse idCategory1 = categoryService.save(categorysave1);

            CategoryRequest categorysave2 = new CategoryRequest();
            categorysave2.setDescription("Movies");
            CategoryResponse idCategory2 = categoryService.save(categorysave2);


            CategoryRequest categorysave3 = new CategoryRequest();
            categorysave3.setDescription("Books");
            CategoryResponse idCategory3 = categoryService.save(categorysave3);


            SupplierRequest suppliersave1 = new SupplierRequest();
            suppliersave1.setName("Panini Comics");
            SupplierResponse idSupplier1 =  supplierService.save(suppliersave1);


            SupplierRequest suppliersave2 = new SupplierRequest();
            suppliersave2.setName("Amazon");
            SupplierResponse idSupplier2 =supplierService.save(suppliersave2);


            SupplierRequest suppliersave3 = new SupplierRequest();
            suppliersave3.setName("Livraria Online");
            SupplierResponse idSupplier3 = supplierService.save(suppliersave3);

//
            ProductRequest productsave1 = new ProductRequest();
            productsave1.setName("Crise nas infinitas terras");
            productsave1.setQuantity_available(10);
            productsave1.setCategoryId(idCategory1.getId());
            productsave1.setSupplierId(idSupplier1.getId());
            ProductResponse productResponse= productService.save(productsave1);


            ProductRequest productsave2 = new ProductRequest();
            productsave2.setName("Naruto");
            productsave2.setQuantity_available(100);
            productsave2.setCategoryId(idCategory2.getId());
            productsave2.setSupplierId(idSupplier2.getId());
            ProductResponse productResponse2=  productService.save(productsave2);


            ProductRequest productsave3 = new ProductRequest();
            productsave3.setName("One Puch Man");
            productsave3.setQuantity_available(200);
            productsave3.setCategoryId(idCategory3.getId());
            productsave3.setSupplierId(idSupplier3.getId());
            ProductResponse productResponse3=  productService.save(productsave3);


            log.debug("idCategory1", idCategory1);
            log.debug("idCategory2", idCategory2);
            log.debug("idCategory3", idCategory3);
            log.debug("idSupplier1", idSupplier1);
            log.debug("idSupplier2", idSupplier2);
            log.debug("idSupplier3", idSupplier3);
            log.debug("productResponse1", productResponse);
            log.debug("productResponse2", productResponse2);
            log.debug("productResponse3", productResponse3);
        };
    }
}
