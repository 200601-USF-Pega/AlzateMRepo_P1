package com.revature.onlinestoreapp.models;

import java.io.Serializable;

public class Customer {

    int customer_id;
    String firstName;
    String lastName;
    String email;
    String password;
    String street;
    String city;
    String state;
    String zipCode;
    String phoneNum;
    String userType = "Customer";


    /*
    Constructor used to create account for P0
     */
    public Customer(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public Customer(String firstName, String lastName) {
        this.customer_id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Customer(int customer_id, String firsName, String lastName) {
        this.customer_id = customer_id;
        this.firstName = firsName;
        this.lastName = lastName;
    }

    public Customer(){

    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
