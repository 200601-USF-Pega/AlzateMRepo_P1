package com.revature.onlinestoreapp.models;

public class Product {

    int product_id;
    String name;
    double price;
    String description;


    public Product(String name, double price, String description) {
        this.product_id = 0;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(int product_id, String name, double price, String description) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
