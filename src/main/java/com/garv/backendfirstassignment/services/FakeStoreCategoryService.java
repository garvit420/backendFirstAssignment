package com.garv.backendfirstassignment.services;

import com.garv.backendfirstassignment.models.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Category> getAllCategories() {
        String[] fakeStoreCategories = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );

        if (fakeStoreCategories != null) {
            List<Category> categories = new ArrayList<>();
            for (String category : fakeStoreCategories) {
                Category category1 = new Category();
                category1.setName(category);
                categories.add(category1);
            }

            return categories;
        }

        return null;
    }

}
