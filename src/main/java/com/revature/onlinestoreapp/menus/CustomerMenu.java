package com.revature.onlinestoreapp.menus;

import com.revature.onlinestoreapp.dao.IProductRepo;
import com.revature.onlinestoreapp.dao.IUserRepo;
import com.revature.onlinestoreapp.service.ProductService;
import com.revature.onlinestoreapp.service.UserService;

import java.util.Scanner;

public class CustomerMenu implements IMenu {

    IProductRepo productRepo;
    IUserRepo userRepo;

    private Scanner scanner = new Scanner(System.in);
    CustomerPurchaseMenu purchaseMenu = new CustomerPurchaseMenu();



    @Override
    public void start(){

        ProductService productService = null;

        try{

            productService = new ProductService(productRepo);

        }catch(Exception e){

            e.getMessage();
        }

        UserService userService = null;

        try{

            userService = new UserService(userRepo);

        }catch(Exception e){

            e.getMessage();
        }

        String userInput;

        System.out.println("Login Success - You are in Customer Menu");

        do {

            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("[0] Look at Items currently in Stock");
            System.out.println("[1] Log Out - Return to Main Menu");


            userInput = scanner.nextLine();


            switch (userInput) {
                case "0":

                    //Displays All Current products
                    productService.getProducts();
                    //call customerMenu
                    purchaseMenu.start();

                    break;

                case "1":

                    //userService.viewPaymentInfo();
                    //System.out.println("Transaction History");
                    System.out.println("Logging Out");



                    break;

                default:
                    System.out.println("Invalid input please try again!");


            }


        } while (!userInput.equals("1"));


    }
}
