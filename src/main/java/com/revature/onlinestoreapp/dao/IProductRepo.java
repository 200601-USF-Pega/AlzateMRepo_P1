package com.revature.onlinestoreapp.dao;

import com.revature.onlinestoreapp.models.Cart;
import com.revature.onlinestoreapp.models.LineItems;
import com.revature.onlinestoreapp.models.OrderTotal;
import com.revature.onlinestoreapp.models.Product;

import java.util.ArrayList;

public interface IProductRepo {

    public Product addProduct(Product product);
    public void removeProduct(int id);
    public Cart enterCart(Cart cart);
    public LineItems addLineItem(LineItems items);

    public ArrayList<OrderTotal> totalOrder();
    public ArrayList<Product> getAllProducts();


}
