package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.dao.IProductRepo;
import com.revature.onlinestoreapp.dao.ProductRepoDB;
import com.revature.onlinestoreapp.models.Product;

import java.util.ArrayList;

public class ProductService {

    ValidationService inputValidation = new ValidationService();
    IProductRepo repo;

    public ProductService(IProductRepo repo){
        this.repo = repo;
    }

    ProductRepoDB productRepoDB = null;

    public void createNewProduct(){
        boolean success = false;

        try{

            productRepoDB = new ProductRepoDB();

        } catch(Exception e) {

            e.getMessage();


        }

        do{
            String name = inputValidation.getValidStringInput("Enter name of product: ");
            double price = inputValidation.getValidDouble("Enter price of product: ");
            String description = inputValidation.getValidStringInput("Enter brief product description: ");

            try {

                Product newProduct = new Product(name, price, description);

                productRepoDB.addProduct(newProduct);
                success = true;


            }catch(Exception e) {
                System.out.println("Failed to add product");

            }


        }while(!success);

    }

    public void enterCart(){
        boolean success = false;

        try{

            productRepoDB = new ProductRepoDB();
        } catch(Exception e) {

            e.getMessage();
        }

        do{
            int customerId = inputValidation.getValidInt("Enter your CustomerID:  ");

            try {
                //Product productToDelete = new Product(name, price, description);

                productRepoDB.enterCart(customerId);
                success = true;

            }catch(Exception e) {
                System.out.println("Failed to purchase product");
            }

       }while(!success); // for now it will only run once
    }

    public void addLineItem(){
        boolean success = false;

        try{

            productRepoDB = new ProductRepoDB();
        } catch(Exception e) {

            e.getMessage();
        }

        do{
            int cartId = inputValidation.getValidInt("Enter cartID:  ");
            int productId = inputValidation.getValidInt("Enter productID : ");
            int quantity = inputValidation.getValidInt("Enter the quantity of the product: ");


            try {
                //Product productToDelete = new Product(name, price, description);

                productRepoDB.addLineItem(cartId, productId, quantity);
                System.out.println("Product added to Cart");

                success = true;

            }catch(Exception e) {
                System.out.println("Failed to purchase product");
            }

        }while(!success);

    }

    public void deleteProduct(){
        boolean success = false;

        try{

            productRepoDB = new ProductRepoDB();

        } catch(Exception e) {

            e.getMessage();


        }

        do{
            //String name = inputValidation.getValidStringInput("Enter name of product: ");
            //double price = inputValidation.getValidDouble("Enter price of product: ");
            int productId = inputValidation.getValidInt("Enter Product ID of item you want to delete:  ");

            try {

                //Product productToDelete = new Product(name, price, description);

                productRepoDB.removeProduct(productId);
                success = true;


            }catch(Exception e) {
                System.out.println("Failed to delete product");

            }


        }while(!success);

    }

    public void totalOrders(){
        boolean success = false;

        try{

            productRepoDB = new ProductRepoDB();
        } catch(Exception e) {

            e.getMessage();
        }

        do{

            try {

                productRepoDB.totalOrder();
                System.out.println("Total Order");

                success = true;

            }catch(Exception e) {
                System.out.println("Failed to purchase product");
            }

        }while(!success);

    }

    public void getProducts() {
        try{

            productRepoDB = new ProductRepoDB();

        } catch(Exception e) {

            e.getMessage();


        }

        ArrayList<ArrayList<String>> retrievedProduct = productRepoDB.getAllProducts();
        for (ArrayList<String> product : retrievedProduct){
            System.out.println(product);
        }
    }
}
