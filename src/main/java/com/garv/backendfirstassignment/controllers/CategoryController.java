package com.garv.backendfirstassignment.controllers;

import com.garv.backendfirstassignment.models.Category;
import com.garv.backendfirstassignment.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/products/categories")
    public List<Category> getAllCategories(){

        return categoryService.getAllCategories();
    }

}
