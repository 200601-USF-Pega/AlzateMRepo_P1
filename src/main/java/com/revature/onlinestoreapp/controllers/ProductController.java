package com.revature.onlinestoreapp.controllers;

import javax.servlet.http.HttpServletRequest;

public class ProductController {

    public static String getProducts(HttpServletRequest req){
        System.out.println("Getting Products");

        return "<products.html";

    }
}
