package com.geekbrains.products.products;

import java.util.Collections;
import java.util.List;

public interface ProductRepo {
    default List<Product> getProductList(List<Product> products) {
        return Collections.unmodifiableList(products);
    }

    void add(Product product);

    void delete(Product product);

    void update(Long id, String newTitle);

    void update(Long id, Double newCost);

    Product findById(Long Id);

    Product findByTitle(String title);
}

