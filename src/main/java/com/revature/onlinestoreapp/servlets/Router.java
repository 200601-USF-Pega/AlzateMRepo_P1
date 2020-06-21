package com.revature.onlinestoreapp.servlets;

import javax.servlet.http.HttpServletRequest;

public class Router {

    public static String routeTo(HttpServletRequest req) {
        System.out.println(req.getRequestURI());
        switch (req.getRequestURI()) {
            case "/OnlineStoreApp/customerLogin.html":
                //route logic goes here

            default:

                return "customerLogin.html";
        }





    }
}
