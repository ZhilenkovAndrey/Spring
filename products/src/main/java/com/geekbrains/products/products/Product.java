package com.geekbrains.products.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long id;
    private String title;
    private double cost;

    public Product (Long id, String title, Double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
}
