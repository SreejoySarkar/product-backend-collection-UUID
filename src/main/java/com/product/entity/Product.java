package com.product.entity;

import lombok.*;

//@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@Builder
public class Product {
    private String id;// UUID ID AUTO-GENERATION
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
