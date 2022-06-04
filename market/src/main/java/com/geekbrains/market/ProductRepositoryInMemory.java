package com.geekbrains.market;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class ProductRepositoryInMemory implements ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Milk", 30.0));
        this.products.add(new Product(2L, "Bread", 25.0));
        this.products.add(new Product(3L, "Cheese", 80.0));
        this.products.add(new Product(4L, "Meat", 180.0));
        this.products.add(new Product(5L, "Fish", 240.0));
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Product> findByTitle (String title) {
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst();
    }
}
