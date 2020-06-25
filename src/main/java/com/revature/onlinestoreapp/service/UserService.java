package com.revature.onlinestoreapp.service;


import com.revature.onlinestoreapp.dao.UserRepoDB;
import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.PaymentInfo;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/user")
public class UserService {

    @POST
    @Path("/newcustomer/form")
    public Response addNewCustomerForm
            (@FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
             @FormParam("email") String email, @FormParam("password")String password,
             @FormParam("cardNum") String cardNum, @FormParam("securityCode") String securityCode) throws IOException {

        UserRepoDB userRepoDB = new UserRepoDB();

        userRepoDB.addCustomer(new Customer(firstname,lastname,email,password), new PaymentInfo(cardNum, securityCode));


        return this.getAllCustomers();
    }




    @POST
    @Path("/newcustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNewCustomer (Customer customer, PaymentInfo paymentInfo){
        UserRepoDB persondaodb = new UserRepoDB();
        persondaodb.addCustomer(customer, paymentInfo);

    }


    @GET
    @Path("/allpeople")
    @Consumes("application/json")
    public Response getAllCustomers() throws IOException {
        UserRepoDB userRepoDB = new UserRepoDB();
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userRepoDB.getAllCustomers());
        return Response
                .status(Response.Status.OK)
                .entity(response)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}