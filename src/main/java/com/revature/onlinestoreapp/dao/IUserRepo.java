package com.revature.onlinestoreapp.dao;
import java.util.ArrayList;

import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.PaymentInfo;

public interface IUserRepo {

    public Customer addCustomer(Customer customer, PaymentInfo paymentInfo);
    public Admin addAdmin(Admin admin);

    public void viewPaymentInfo(int customerID);
    public ArrayList<ArrayList<String>> getUserPaymentInfo();
    public ArrayList<ArrayList<String>> getAllCustomers();
}
