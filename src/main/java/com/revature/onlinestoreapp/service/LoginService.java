package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.Customer;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/Login")
public class LoginService {

    @POST
    @Path("/customer")
    public Response customerLogin(@FormParam("email") String email, @FormParam("password") String password) throws URISyntaxException {
        Customer customer = new Customer();
        CredentialVerification credentialVerification = new CredentialVerification();

        customer.setEmail(email);
        customer.setPassword(password);

        if(credentialVerification.loginCustomer(customer)){

            URI uri = UriBuilder.fromUri("../customerPage.html").build();
            System.out.println("Customer Login works REST");

            return Response.temporaryRedirect(uri).build();
        }
        else {

            System.out.println("Wrong email and Password");

        }
        return Response.status(401).build();
    }

    @POST
    @Path("/admin")
    public Response adminLogin(@FormParam("email") String email, @FormParam("password") String password) throws URISyntaxException {

        Admin admin = new Admin();
        CredentialVerification credentialVerification = new CredentialVerification();

        admin.setEmail(email);
        admin.setPassword(password);

        if(credentialVerification.loginAdmin(admin)){

            URI uri = UriBuilder.fromUri("../adminPage.html").build();
            System.out.println("Admin Login works REST");

            return Response.temporaryRedirect(uri).build();
        }
        else {

            System.out.println("Wrong email and Password");

        }

        return Response.status(401).build();
    }


}
