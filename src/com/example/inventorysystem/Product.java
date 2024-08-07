package com.example.inventorysystem;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    public static int totalProducts = 0;
    public static int nextId = 0;

    public Product() {
        totalProducts++;
    }

    public Product(int id, String name, double price, int quantity) {
        this.id = id + 1;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static int generateId() {
        return nextId++;
    }

    @Override
    public String toString() {
        return "Товар: " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", price= " + price +
                ", quantity= " + quantity;
    }
}
