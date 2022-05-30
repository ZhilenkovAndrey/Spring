package ru.geekbrains.firstapp;

public class Product {
    private int id;
    private String title;
    private double cost;

    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String toString() {
        return id + " " + title + " " + cost;
    }
}
