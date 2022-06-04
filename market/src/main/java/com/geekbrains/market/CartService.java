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

    public void addToCartByProductId(Long productId) {
        Product product = productService.findById(productId).get();
        cart.add(product);
    }

    public void clearCurrentCart() {
        cart.clear();
    }

    public void removeFromCart(String productTitle) {
        cart.removeByTitle(productTitle);
    }
}
