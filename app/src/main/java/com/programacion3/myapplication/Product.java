package com.programacion3.myapplication;

/**
 * Created by adro_ on 4/17/2018.
 */

public class Product {
    private int id;
    private double price;
    private int quantity;
    private String description;
    private int image;

    public Product(int id, double price, int quantity, String description, int image) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
