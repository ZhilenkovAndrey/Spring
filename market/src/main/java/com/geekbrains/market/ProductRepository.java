package com.geekbrains.market;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> findByTitle(String title);
}
