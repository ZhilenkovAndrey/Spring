package com.geekbrains.market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class OrderService {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String a;

    @Autowired
    public OrderService(UserService userService, CartService cartService, ProductService productService) {
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
    }

    public void printListProducts() {
        System.out.println("---------------------------------------------------------");
        productService.findAll().stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
        System.out.println();
        System.out.println("Do you wont to make an order: y/n ");
    }

    public void beginOrdering() {
        try {
            a = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (a.equalsIgnoreCase("y")) createNewOrder();
        if (a.equalsIgnoreCase("n")) printListProducts();
        if (!a.equalsIgnoreCase("y") || !a.equalsIgnoreCase("n")) {
            System.out.println(" Unknown command");
            printListProducts();
        }
    }

    public Order createNewOrder() {
        Order order = new Order();

        order.setId(UUID.randomUUID().toString());

        User currentUser = userService.getCurrentUser();
        order.setUser(currentUser);

        Cart currentCart = cartService.getCurrentCart();

        for (Product p : currentCart.getProducts()) {
            if (!productService.isProductIdExist(p.getId())) {
                throw new RuntimeException("What???");
            }
        }

        order.setProducts(new ArrayList<>(currentCart.getProducts()));
        cartService.clearCurrentCart();

        return order;
    }
}
