package com.garv.backendfirstassignment.services;

import com.garv.backendfirstassignment.dtos.FakeStoreProductDto;
import com.garv.backendfirstassignment.models.Category;
import com.garv.backendfirstassignment.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        if (fakeStoreProductDtos != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                Product product = covertToProduct(fakeStoreProductDto);
                products.add(product);
            }
            return products;
        }

        return null;
    }

    private Product covertToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if(fakeStoreProductDto == null) return null;

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setImageUrl(fakeStoreProductDto.getImage());

        return product;
    }

    @Override
    public Product getSingleProduct(long id) {

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );

        return covertToProduct(fakeStoreProductDto);
    }

    private FakeStoreProductDto convertToFakeStoreProductDto(Product product) {
        if(product == null) return null;

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        if(product.getCategory() != null) fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());

        return fakeStoreProductDto;
    }

    @Override
    public Product createProduct(Product product) {

        FakeStoreProductDto fakeStoreProductDto = convertToFakeStoreProductDto(product);

        FakeStoreProductDto fakeStoreProductDtoOutput = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );

        return covertToProduct(fakeStoreProductDtoOutput);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/" + category,
                FakeStoreProductDto[].class
        );

        if (fakeStoreProductDtos != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                Product product = covertToProduct(fakeStoreProductDto);
                products.add(product);
            }
            return products;
        }

        return null;
    }

    @Override
    public void deleteProduct(long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }

    @Override
    public void updateProduct(Product product, long id) {
        FakeStoreProductDto fakeStoreProductDto = convertToFakeStoreProductDto(product);

        restTemplate.put(
                "https://fakestoreapi.com/products/" + id,
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );

    }
}
