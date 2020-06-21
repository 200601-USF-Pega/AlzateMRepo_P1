package com.revature.onlinestoreapp.menus;

import com.revature.onlinestoreapp.dao.IUserRepo;

import com.revature.onlinestoreapp.service.UserService;

public class CustomerNewAccount implements IMenu {

    //private ConnectionService connectionService = new ConnectionService().getInstance();
    IUserRepo repo;




    @Override
    public void start() {

        UserService userService = null;

        try{

            userService = new UserService(repo);

        }catch(Exception e){

            e.getMessage();
        }



        System.out.println("Welcome new Customer!");
        System.out.println("Enter your information to create a new account.");
        System.out.println("");

        try {
            userService.createNewCustomer();

        } catch(Exception e){

            e.getMessage();

        }

    }
}
