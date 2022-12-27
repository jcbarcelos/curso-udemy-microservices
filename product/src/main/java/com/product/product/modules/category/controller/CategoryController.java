package com.product.product.modules.category.controller;

import com.product.product.modules.category.dto.CategoryRequest;
import com.product.product.modules.category.dto.CategoryResponse;
import com.product.product.modules.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    private CategoryRequest categoryRequest;

    @PostMapping
    @Transactional
    public CategoryResponse save(@RequestBody CategoryRequest request) {
        CategoryRequest categorysave1 = new CategoryRequest();
        CategoryRequest categorysave2 = new CategoryRequest();
        CategoryRequest categorysave3 = new CategoryRequest();
        categorysave1.setDescription("Comic Books");
        categorysave2.setDescription("Movies");
        categorysave3.setDescription("Books");
        categoryService.save(categorysave1);
        categoryService.save(categorysave2);
        categoryService.save(categorysave3);
        return categoryService.save(request);
    }

    @GetMapping()
    public List<CategoryResponse> findA() {
        return categoryService.findAll();
    }
  @GetMapping("{id}")
    public CategoryResponse findById(@PathVariable Integer id) {
        return categoryService.findByIdResponse(id);
    }

    @GetMapping("description/{description}")
    public List<CategoryResponse> findById(@PathVariable String description) {
        return categoryService.findByDescription(description);
    }
}
