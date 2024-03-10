package com.garv.backendfirstassignment.controllers;

import com.garv.backendfirstassignment.models.Product;
import com.garv.backendfirstassignment.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id){

        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public  Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/products/category/{name}")
    public List<Product> getProductByCategory(@PathVariable("name") String name){

        return productService.getProductByCategory(name);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable("id") long id){
        productService.updateProduct(product, id);
    }

}
