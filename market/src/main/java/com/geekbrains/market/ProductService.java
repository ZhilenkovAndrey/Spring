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

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public boolean isProductIdExist(Long id) {
        return productRepository.findAll().stream().anyMatch(p -> p.getId().equals(id));
    }

    public List<Product> findAll () {
        return productRepository.findAll();
    }
}
