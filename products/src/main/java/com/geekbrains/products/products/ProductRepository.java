package com.geekbrains.products.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class ProductRepository implements ProductRepo {
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
    public List<Product> getProductList(List<Product> products) {
        return ProductRepo.super.getProductList(products);
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }

    @Override
    public void update(Long id, String newTitle) {
        products.stream().filter(id::equals).forEachOrdered(p -> p.setTitle(newTitle));
    }

    @Override
    public void update(Long id, Double newCost) {
        products.stream().filter(id::equals).forEachOrdered(p -> p.setCost(newCost));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(id::equals).findFirst()
                .orElseThrow(() -> new RuntimeException("Incorrect id"));
    }

    @Override
    public Product findByTitle(String title) {
        return products.stream().filter(title::equals).findFirst()
                .orElseThrow(() -> new RuntimeException("Incorrect id"));
    }
}