package com.garv.backendfirstassignment.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
}
