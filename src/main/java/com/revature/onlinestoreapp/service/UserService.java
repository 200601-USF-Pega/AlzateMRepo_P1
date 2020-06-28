package com.revature.onlinestoreapp.service;


import com.revature.onlinestoreapp.dao.IUserRepo;
import com.revature.onlinestoreapp.dao.UserRepoDB;
import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.PaymentInfo;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

@Path("/user")
public class UserService {

    private static final Logger logger = Logger.getLogger(LoginService.class);

    IUserRepo userRepo = new UserRepoDB();

    @POST
    @Path("/newcustomer/form")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewCustomerForm(Customer customer) throws IOException {

        UserRepoDB userRepoDB = new UserRepoDB();
        URI uri = UriBuilder.fromUri("../customerLogin.html").build();

        userRepoDB.addCustomer(customer);

        System.out.println(customer.toString());

        logger.info("New customer " + customer.getEmail() + " created successfully");

        return Response.temporaryRedirect(uri).build();
    }

    @POST
    @Path("/newAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewAdmin(Admin admin) throws IOException {

        UserRepoDB userRepoDB = new UserRepoDB();
        URI uri = UriBuilder.fromUri("../adminLogin.html").build();

        userRepoDB.addAdmin(admin);

        System.out.println(admin.toString());

        logger.info("New admin " + admin.getEmail() + " created successfully");

        return Response.temporaryRedirect(uri).build();


    }


}