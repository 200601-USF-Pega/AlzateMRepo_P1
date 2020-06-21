package com.revature;

import com.revature.onlinestoreapp.menus.StartingMenu;
import com.revature.onlinestoreapp.service.ConnectionService;

public class App {
    public static void main(String [] args)  {

        ConnectionService connectionService = ConnectionService.getInstance();


        StartingMenu mainMenu = new StartingMenu();
        mainMenu.start();

        //To DO
        /*
            Create Admin functionality
            Add Items to product table
            Columns
                Include
                name varchar
                price INT
                description TEXT
                admin_id -> is Foreign key, treat like Generated value from customer and admin
         */
    }
}
