package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.Customer;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

@Path("/Login")
public class LoginService {

    private static final Logger logger = Logger.getLogger(LoginService.class);

    @POST
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response customerLogin(Customer customer) throws URISyntaxException {
        CredentialVerification credentialVerification = new CredentialVerification();

        //customer.setEmail(email);
        //customer.setPassword(password);

        if(credentialVerification.loginCustomer(customer)){

            URI uri = UriBuilder.fromUri("../customerPage.html").build();
            System.out.println("Customer Login works REST");

            //return Response.temporaryRedirect(uri).build();
            logger.info("Customer " + customer.getEmail() + " logged in.");
            return Response.status(304).build();
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

            logger.info("Admin " + admin.getEmail() + " logged in");

            return Response.temporaryRedirect(uri).build();
        }
        else {

            logger.error("Admin failed to log in");

            System.out.println("Wrong email and Password");

        }

        return Response.status(401).build();
    }


}
