package com.revature.onlinestoreapp.servlets;

import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.service.CredentialVerification;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class CustomerLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("In the doGet method of CustomerLoginServlet");
        req.getRequestDispatcher(Router.routeTo(req)).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer customer = new Customer();
        CredentialVerification credentialVerification = new CredentialVerification();

        customer.setEmail(req.getParameter("email"));
        customer.setPassword(req.getParameter("password"));

        if(credentialVerification.loginCustomer(customer)){

            resp.sendRedirect(req.getContextPath() + "/customerPage.html");
            System.out.println("New login method works");

        } else {

            req.getRequestDispatcher("customerLogin.html").forward(req, resp);
            System.out.println("Something is wrong");
        }


    }

}
