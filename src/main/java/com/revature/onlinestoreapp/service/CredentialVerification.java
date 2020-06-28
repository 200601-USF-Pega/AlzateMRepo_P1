package com.revature.onlinestoreapp.service;

import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.web.ConnectionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

//This class is used to Verify login information
public class CredentialVerification {

    ValidationService inputValidation = new ValidationService();
    ConnectionService connectionService = new ConnectionService().getInstance();


    public CredentialVerification() {

    }

    public boolean emailVerification(String prompt, String sqlTableStatement) {

        try {

            //System.out.println("Welcome Back - Customer Login");
            String userInput = inputValidation.getValidStringInput(prompt);
            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            (sqlTableStatement + "'"+ userInput + "'");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = inputCheck.executeQuery();


            //Checks to see if result has appropriate email
            if (resultSet.next()) {

                //String email = resultSet.getString("email");


                //int id = resultSet.getInt(1);
                //String firstName = resultSet.getString(2);
                //String lastName = resultSet.getString(3);


                //System.out.println("Records Match!"); //For testing purposes

                //success = true;
                return true;

            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

        return false;
    }


    public boolean passwordVerification(String prompt, String sqlTableStatement) {

        try {

            //System.out.println("Welcome Back - Customer Login");
            String userInput = inputValidation.getValidStringInput(prompt);
            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            (sqlTableStatement + "'"+ userInput + "'");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = inputCheck.executeQuery();


            //Checks to see if result has appropriate email
            if (resultSet.next()) {

                String email = resultSet.getString("email");


                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);


                System.out.println("Records Match!"); //For testing purposes
                System.out.println("ID: " + id);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);

                //success = true;
                return true;

            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

        return false;
    }

    /**
     *  New login verification for project 1. Gets both email and password at the same time.
     * @param customer object
     * @return boolean value depending on input
     */
    public boolean loginCustomer(Customer customer){

        try {

            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            ("SELECT * FROM customer WHERE email=? AND password=?");

            inputCheck.setString(1, customer.getEmail());
            inputCheck.setString(2, customer.getPassword());

            ResultSet resultSet = inputCheck.executeQuery();

            if (resultSet.next()) {


                return true;

            } else {

                System.out.println("Input does not match");
                return false;
            }

        } catch (SQLException e) {
            return false;
        }

    }


    /**
     *  New login verification for project 1. Gets both email and password at the same time.
     * @param admin customer object
     * @return boolean value depending on input
     */
    public boolean loginAdmin(Admin admin){

        try {

            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            ("SELECT * FROM admin WHERE email=? AND password=?");

            inputCheck.setString(1, admin.getEmail());
            inputCheck.setString(2, admin.getPassword());

            ResultSet resultSet = inputCheck.executeQuery();

            if (resultSet.next()) {


                return true;

            } else {

                System.out.println("Input does not match");
                return false;
            }

        } catch (SQLException e) {
            return false;
        }


    }

}