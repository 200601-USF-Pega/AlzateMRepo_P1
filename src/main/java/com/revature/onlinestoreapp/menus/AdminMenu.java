package com.revature.onlinestoreapp.menus;

import com.revature.onlinestoreapp.dao.IProductRepo;
import com.revature.onlinestoreapp.service.ProductService;


import java.util.Scanner;

public class AdminMenu implements IMenu {

    private Scanner scanner = new Scanner(System.in);
    private AdminNewAccount adminNewAccount = new AdminNewAccount();


    IProductRepo repo;


    @Override
    public void start(){

        ProductService productService = null;

        try{

            productService = new ProductService(repo);

        }catch(Exception e){

            e.getMessage();
        }

        String userInput;


        System.out.println("");

        do {
            System.out.println("Admin Menu");
            System.out.println("");

            System.out.println("[0] Create Admin Account");
            System.out.println("[1] Add new Product to Inventory");
            System.out.println("[2] Delete Product from Inventory");
            System.out.println("[3] Return to Main Menu");

            userInput = scanner.nextLine();


            switch (userInput) {
                case "0":
                    //Takes me to new admin
                    adminNewAccount.start();

                    break;

                case "1":
                    //Update inventory Menu - For ADD list attributes and price
                    //  - For Delete Drop row from Table
                    System.out.println("Current Products");

                    productService.getProducts();
                    productService.createNewProduct();

                    System.out.println("Current Products");
                    productService.getProducts();

                    break;
                case "2":

                    System.out.println("Current products!");

                    productService.getProducts();
                    productService.deleteProduct();

                    System.out.println("Current products");
                    productService.getProducts();

                    break;

                case "3":
                    System.out.println("Logging Out");
                    break;



                default:
                    System.out.println("Invalid input please try again!");



            }

        }while(!userInput.equals("3"));
    }
}
