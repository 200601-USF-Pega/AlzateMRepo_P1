package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.dao.IProductRepo;
import com.revature.onlinestoreapp.dao.ProductRepoDB;
import com.revature.onlinestoreapp.models.Product;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;
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
        System.out.println(product.toString());


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
