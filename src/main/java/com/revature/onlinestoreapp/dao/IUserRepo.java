package com.revature.onlinestoreapp.dao;
import java.util.ArrayList;

import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.PaymentInfo;

public interface IUserRepo {

    public Customer addCustomer(Customer customer);
    public Admin addAdmin(Admin admin);

    public ArrayList<Customer> getCustomerInfo(String email);
}
