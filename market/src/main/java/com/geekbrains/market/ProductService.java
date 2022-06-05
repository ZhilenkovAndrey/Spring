package com.geekbrains.market;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> find(int id) {
        return productRepository.find(id);
    }

    public Optional<Product> find(String title) {
        return productRepository.find(title);
    }

    public boolean isProductIdExist(int id) {
        return productRepository.findAll().stream().anyMatch(p -> p.getId() == id);
    }

    public List<Product> findAll () {
        return productRepository.findAll();
    }
}
