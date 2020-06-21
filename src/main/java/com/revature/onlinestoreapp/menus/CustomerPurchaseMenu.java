package com.revature.onlinestoreapp.menus;

import com.revature.onlinestoreapp.dao.IProductRepo;
import com.revature.onlinestoreapp.service.ProductService;

import java.util.Scanner;

public class CustomerPurchaseMenu implements IMenu {

    IProductRepo productRepo;

    private Scanner scanner = new Scanner(System.in);



    @Override
    public void start(){

        ProductService productService = null;

        try{

            productService = new ProductService(productRepo);

        }catch(Exception e){

            e.getMessage();
        }

        String userInput;

        do {

            System.out.println("What would you like to do?");
            System.out.println("[0] Add Item to cart");
            System.out.println("[1] Complete Purchase");
            System.out.println("[2] Go Back to Customer Menu");

            userInput = scanner.nextLine();
            switch (userInput) {
                case "0":

                    //asks for your customer Id - make sure you display when you log in

                    //Display the cart Id when its created
                    productService.enterCart();

                    //asks for cart Id and for productId - Make sure you display them
                    productService.addLineItem();


                    break;
                case "1":

                    productService.totalOrders();
                    System.out.println("");

                    System.out.println("Purchase complete - Thank you for shopping");

                    break;

                case "2":

                    System.out.println("Going Back to Customer Menu...");

                    break;

            }
        }while(!userInput.equals("2"));
    }
}