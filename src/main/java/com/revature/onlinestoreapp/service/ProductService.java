package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.dao.IProductRepo;
import com.revature.onlinestoreapp.dao.ProductRepoDB;
import com.revature.onlinestoreapp.models.Cart;
import com.revature.onlinestoreapp.models.LineItems;
import com.revature.onlinestoreapp.models.Product;
import com.revature.onlinestoreapp.models.Customer;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;

@Path("/products")
public class ProductService {

    IProductRepo productRepo = new ProductRepoDB();


    @POST
    @Path("/newproduct/form")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewProductForm (Product product) throws IOException {

        ProductRepoDB productRepoDB = new ProductRepoDB();

        productRepoDB.addProduct(product);
        //System.out.println(product.toString());


        return Response.ok().status(201).build();
    }




    @DELETE
    @Path("/removeProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeProduct(int product_id) {

        productRepo.removeProduct(product_id);

        System.out.println("Called productRepo.removeProduct");

        return Response.ok().status(201).build();

    }

    @POST
    @Path("/addCart/form")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCart(Cart cart) throws IOException {


        ProductRepoDB productRepoDB = new ProductRepoDB();

        productRepoDB.enterCart(cart);

        return Response.ok().status(201).build();
    }


    @POST
    @Path("/lineItems/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLineItems(LineItems items) throws IOException {


        ProductRepoDB productRepoDB = new ProductRepoDB();

        productRepoDB.addLineItem(items);


        return Response.ok().status(201).build();
    }

    @GET
    @Path("/orderTotal")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderTotal() {

        //System.out.println(productRepo.totalOrder());

        return Response.ok(productRepo.totalOrder()).build();
    }



    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        for(Product product : productRepo.getAllProducts()){
            System.out.println(product.toString());
        }
        return Response.ok((ArrayList<Product>)productRepo.getAllProducts()).build();
    }
}
