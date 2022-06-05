package com.geekbrains.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CartService {
    private ProductService productService;
    private Cart cart;

    @Autowired
    public CartService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        this.cart = new Cart();
    }

    public Cart getCurrentCart() {
        return cart;
    }

    public void addToCart(int productId) {
        Product product = productService.find(productId).get();
        cart.add(product);
    }

    public void addToCart(String productTitle) {
        Product product = productService.find(productTitle).get();
        cart.add(product);
    }

    public void clearCurrentCart() {
        cart.clear();
    }

    public void removeFromCart(String productTitle) {
        cart.remove(productTitle);
    }

    public void removeFromCart(int productId) {
        cart.remove(productId);
    }
}
