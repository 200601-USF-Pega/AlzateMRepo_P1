package com.revature.onlinestoreapp.models;

public class Cart {

    int customer_id;

    public Cart(int customer_id) {
        this.customer_id = customer_id;
    }

    public Cart() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
