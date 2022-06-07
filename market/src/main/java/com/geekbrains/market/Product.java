package com.geekbrains.market;


public class Product {
    private int id;
    private String title;
    private double cost;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Product() {
    }

    public Product(int id, String title,double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product: " + id + ". " + title +
                " cost= " + cost;
    }
}
