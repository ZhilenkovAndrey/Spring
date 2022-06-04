package com.geekbrains.market;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        OrderService orderService = context.getBean(OrderService.class);

        orderService.printListProducts();
        orderService.beginOrdering();


//        Order order = orderService.createNewOrder();
//        System.out.println(order);
//
//        System.out.println(cartService.getCurrentCart());

        context.close();

        // 1. Что такое спринг бин
        // 2. Какие есть способы инжекции зависимостей
    }
}
