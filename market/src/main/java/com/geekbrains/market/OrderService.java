package com.geekbrains.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
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

    public void beginOrdering(AnnotationConfigApplicationContext context, Order order) {
        try {
            a = reader.readLine();
        } catch (IOException e) {
            System.out.println(" Unknown command");
            beginOrdering(context, order);
        }

        if (a.equalsIgnoreCase("y")) {
            createNewOrder(order);
        } else if (a.equalsIgnoreCase("n")) {
            System.out.println(" Press q to quite");
            try {
                a = reader.readLine();
                exit(a, context, order);
            } catch (IOException e) {
                System.out.println(" Unknown command");
                beginOrdering(context, order);
            }
        } else {
            System.out.println(" Unknown command");
            beginOrdering(context, order);
        }
    }

    public Order createNewOrder(Order order) {

        order.setId(UUID.randomUUID().toString());

        User currentUser = userService.getCurrentUser();
        order.setUser(UserRegistration(currentUser));

        Cart currentCart = productSetting(cartService);

//        for (Product p : currentCart.getProducts()) {
//            if (!productService.isProductIdExist(p.getId())) {
//                throw new RuntimeException("What???");
//            }
//        }

        order.setProducts(new ArrayList<>(currentCart.getProducts()));
//        cartService.clearCurrentCart();

        return order;
    }

    public User UserRegistration(User currentUser) {
        System.out.println("Write your name:");
        try {
            a = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentUser.setUsername(a);
        return currentUser;
    }

    public Cart productSetting(CartService cartService) {
        while (true) {
            System.out.println("Enter name or id of product:");
            System.out.println("Press f to finish");
            try {
                a = reader.readLine();
                cartService.addToCart(a);
            } catch (NoSuchElementException | IOException e) {
                if (a.equalsIgnoreCase("f")) {
                    break;
                }
                try {
                    int c = Integer.parseInt(a);
                    cartService.addToCart(c);
                } catch (NumberFormatException ex) {
                    System.out.println(" Unknown command");
                    productSetting(cartService);
                }
            }
        }
        return cartService.getCurrentCart();
    }

    public void exit(String a, AnnotationConfigApplicationContext context, Order order) {
        if (a.equalsIgnoreCase("q")) {
            context.close();
        } else {
            System.out.println(" Unknown command");
            beginOrdering(context, order);
        }
    }
}
