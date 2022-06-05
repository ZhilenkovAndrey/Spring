package com.geekbrains.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = context.getBean(CartService.class);
        OrderService orderService = context.getBean(OrderService.class);

        orderService.printListProducts();
        orderService.beginOrdering(context);


        context.close();

        // 1. Что такое спринг бин
        // 2. Какие есть способы инжекции зависимостей
    }
}
