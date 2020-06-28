package com.revature.onlinestoreapp.service;


import com.revature.onlinestoreapp.dao.IUserRepo;
import com.revature.onlinestoreapp.dao.UserRepoDB;
import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.PaymentInfo;
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

    IUserRepo userRepo = new UserRepoDB();

    @POST
    @Path("/newcustomer/form")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewCustomerForm(Customer customer) throws IOException {

        UserRepoDB userRepoDB = new UserRepoDB();
        URI uri = UriBuilder.fromUri("../customerLogin.html").build();

        userRepoDB.addCustomer(customer);

        System.out.println(customer.toString());

        return Response.temporaryRedirect(uri).build();
    }








}