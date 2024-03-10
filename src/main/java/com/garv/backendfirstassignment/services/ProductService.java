package com.garv.backendfirstassignment.services;

import com.garv.backendfirstassignment.models.Category;
import com.garv.backendfirstassignment.models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(Product product);

    List<Product> getProductByCategory(String category);

    void deleteProduct(long id);

    void updateProduct(Product product, long id);
}
