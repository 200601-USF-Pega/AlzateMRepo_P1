package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.dao.IUserRepo;
import com.revature.onlinestoreapp.dao.UserRepoDB;
import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.PaymentInfo;

import java.util.ArrayList;
public class UserService {

    ValidationService inputValidation = new ValidationService();
    IUserRepo repo;

    public UserService(IUserRepo repo){
        this.repo = repo;
    }

    UserRepoDB userRepoDB = null;



    //maybe make it return customer object
    public void createNewCustomer() {
        boolean success = false;

        try{

            userRepoDB = new UserRepoDB();

        }catch(Exception e){

            e.getMessage();
        }

        do {

            String firstName = inputValidation.getValidStringInput("Enter first name: ");
            String lastName = inputValidation.getValidStringInput("Enter last name: ");
            String email = inputValidation.getValidStringInput("Enter email address: ");
            String password = inputValidation.getValidStringInput("Enter a password: ");

            System.out.println("Now Please Input Payment Information");
            System.out.println("");

            String cardNum = inputValidation.getValidStringInput("Enter Card Number: ");
            String securityCode = inputValidation.getValidStringInput("Enter Security Code: ");


            try {
                //uses constructor to create new customer object
                Customer newCustomer = new Customer(firstName, lastName, email, password);
                PaymentInfo paymentInfo = new PaymentInfo(cardNum, securityCode);

                /*Thread addCustomerThread = new Thread(() -> {
                    repo.addCustomer(newCustomer);
                    //System.out.println("Account created!");

                });
                addCustomerThread.start();
                 */

                //Moved add customer outside of the thread
                userRepoDB.addCustomer(newCustomer, paymentInfo);

                success = true;
            } catch (Exception e){
                //For now just have this plain message
                System.out.println("Failed to create account");
            }


        }while(!success); //

    }

    public void createNewAdmin(){
        boolean success = false;

        try{

            userRepoDB = new UserRepoDB();

        }catch(Exception e){

            e.getMessage();
        }

        do {

            String firstName = inputValidation.getValidStringInput("Enter first name: ");
            String lastName = inputValidation.getValidStringInput("Enter last name: ");
            String email = inputValidation.getValidStringInput("Enter email address: ");
            String password = inputValidation.getValidStringInput("Enter a password: ");

            try {
                //uses constructor to create new customer object
                Admin newAdmin = new Admin(firstName, lastName, email, password);

                /*Thread addCustomerThread = new Thread(() -> {
                    repo.addCustomer(newCustomer);
                    //System.out.println("Account created!");

                });
                addCustomerThread.start();
                 */
                //Moved add customer outside of the thread
                userRepoDB.addAdmin(newAdmin);
                success = true;
            } catch (Exception e){
                //For now just have this plain message
                System.out.println("Failed to create account");
            }


        }while(!success); //

    }

    //For Customer to add payment information
    public void viewPaymentInfo(){
        boolean success = false;

        try{

            userRepoDB = new UserRepoDB();

        }catch(Exception e){

            e.getMessage();
        }

        do{

            int customerId = inputValidation.getValidInt("Enter your CustomerId: ");

            try{

                //PaymentInfo paymentInfo = new PaymentInfo(cardNum, securityCode);

                userRepoDB.viewPaymentInfo(customerId);
                success = true;

            }catch(Exception e){
                System.out.println("Failed to view payment information");
            }

        }while(!success);

    }

    // Consider making this method be in the admin class
    public void getCustomers() {
        try{

            userRepoDB = new UserRepoDB();

        }catch(Exception e){

            e.getMessage();
        }

        ArrayList<ArrayList<String>> retrievedCustomers = userRepoDB.getAllCustomers();
        for (ArrayList<String> customer : retrievedCustomers){
            System.out.println(customer);
        }
    }


}
