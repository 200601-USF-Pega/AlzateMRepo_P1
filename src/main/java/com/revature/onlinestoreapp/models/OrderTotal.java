package com.revature.onlinestoreapp.models;

public class OrderTotal {

    double total;

    public OrderTotal(double total) {
        this.total = total;
    }

    public OrderTotal() {
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
