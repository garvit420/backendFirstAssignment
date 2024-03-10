package com.garv.backendfirstassignment.services;

import com.garv.backendfirstassignment.models.Category;
import com.garv.backendfirstassignment.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<Category> getAllCategories();
}
