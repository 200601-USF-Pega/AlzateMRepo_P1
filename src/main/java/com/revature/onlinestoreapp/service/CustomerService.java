package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.dao.IUserRepo;
import com.revature.onlinestoreapp.dao.ProductRepoDB;
import com.revature.onlinestoreapp.dao.UserRepoDB;
import com.revature.onlinestoreapp.models.Cart;
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

@Path("/CustomerService/{email}")
public class CustomerService {

    IUserRepo customerRepo = new UserRepoDB();

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerInfo(@PathParam("email") String email) {

        for(Customer customer : customerRepo.getCustomerInfo(email)){
            System.out.println(customer.toString());
        }

        return Response.ok((ArrayList<Customer>)customerRepo.getCustomerInfo(email)).build();
    }


}
