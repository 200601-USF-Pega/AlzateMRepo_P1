package com.revature.onlinestoreapp.models;

public class Cart {

    int cart_id;
    int customer_id;

    public Cart(int customer_id) {

        this.customer_id = customer_id;
    }


    public Cart(int cart_id, int customer_id){
        this.cart_id = cart_id;
        this.customer_id = customer_id;

    }

    public Cart() {
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}

