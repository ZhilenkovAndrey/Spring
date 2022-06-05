package com.geekbrains.market;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> find(int id);
    Optional<Product> find(String title);
}
