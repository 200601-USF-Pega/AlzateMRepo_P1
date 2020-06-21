package com.revature.onlinestoreapp.menus;

import java.util.Scanner;

public class StartingMenu implements IMenu {

    private Scanner scanner = new Scanner(System.in);

    CustomerNewAccount customerNewAccount = new CustomerNewAccount();
    CustomerLogin customerLogin = new CustomerLogin();
    AdminLogin adminLogin = new AdminLogin();

    @Override
    public void start() {

        String userInput;

        do {
            System.out.println("Welcome to My Online Retail App!");
            System.out.println("What would you like to do?");
            System.out.println("[0] Create new account");
            System.out.println("[1] Login as customer");
            System.out.println("[2] Admin Login");
            System.out.println("[3] Exit Program.");
            System.out.println(" ");

            userInput = scanner.nextLine();

            switch (userInput) {
                case "0":
                    //Takes me to new customer account menu
                    customerNewAccount.start();
                    break;

                case "1":

                    customerLogin.start();
                    break;
                case "2":

                    adminLogin.start();
                    break;

                case "3":
                    System.out.println("Exiting...");
                    System.out.println("Come back soon!");
                    break;

                default:
                    System.out.println("Invalid input please try again!");



            }




        } while(!userInput.equals("3")); // for now I will change when I know how many options this will have
    }

}
