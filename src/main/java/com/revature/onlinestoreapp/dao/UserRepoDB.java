package com.revature.onlinestoreapp.dao;

import com.revature.onlinestoreapp.models.Admin;
import com.revature.onlinestoreapp.models.Customer;
import com.revature.onlinestoreapp.models.PaymentInfo;
import com.revature.onlinestoreapp.service.ConnectionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepoDB implements IUserRepo {

    ConnectionService connectionService = ConnectionService.getInstance();

    //this is to set up the connection
    public UserRepoDB() {

    }

    @Override
    public Customer addCustomer(Customer customer, PaymentInfo paymentInfo){

        ResultSet rs = null;

        try {

            PreparedStatement customerStatement = connectionService.getConnection().prepareStatement("INSERT INTO customer " +
                    "(firstName, lastName, email, password) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            customerStatement.setString(1, customer.getFirstName());
            customerStatement.setString(2, customer.getLastName());
            customerStatement.setString(3, customer.getEmail());
            customerStatement.setString(4, customer.getPassword());

            customerStatement.executeUpdate();

            rs = customerStatement.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Key: " + rs.getInt(1));
                customer.setCustomerID(rs.getInt(1));
            }

            //System.out.println(customer.getCustomerID());

            //Right here call create payment info from userService
            PreparedStatement paymentInfoStatement
                    = connectionService.getConnection().prepareStatement("INSERT INTO PaymentInfo (cardNum, securityCode, customer_id) VALUES (?, ?, ?)");

            paymentInfoStatement.setString(1, paymentInfo.getCardNum());
            paymentInfoStatement.setString(2, paymentInfo.getSecurityCode());
            paymentInfoStatement.setInt(3, customer.getCustomerID());

            paymentInfoStatement.executeUpdate();

            // for each loop is possible for adding inventory do this in admin
            // In video its minute 23 to add items into array variable

            return customer;


        } catch (SQLException e) {

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Admin addAdmin(Admin admin) {

        try {

            PreparedStatement adminStatement = connectionService.getConnection().prepareStatement("INSERT INTO admin " +
                    "(firstName, lastName, email, password) VALUES (?, ?, ?, ?)");

            adminStatement.setString(1, admin.getFirstName());
            adminStatement.setString(2, admin.getLastName());
            adminStatement.setString(3, admin.getEmail());
            adminStatement.setString(4, admin.getPassword());

            adminStatement.executeUpdate();

            // for each loop is possible for adding inventory do this in admin
            // In video its minute 23 to add items into array variable

            return admin;


        } catch (SQLException e) {

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();

        }

        return null;
    }

    @Override
    public void viewPaymentInfo(int userInput) {
        try {

            PreparedStatement paymentCheck =
                    connectionService.getConnection().prepareStatement
                            ("SELECT * FROM PaymentInfo WHERE customer_id = " +"''" + userInput + "''");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = paymentCheck.executeQuery();


            if (resultSet.next()) {

                //int customer_id = resultSet.getInt("customer_id");

                int paymentId = resultSet.getInt(1);
                String cardNum = resultSet.getString(2);
                String securitycode = resultSet.getString(3);

                System.out.println("Card Number: " + cardNum);
                System.out.println("Security Code: " + securitycode);


            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            //System.out.println("Input does not match");

            e.getMessage();
        }


    }


    @Override
    public ArrayList<ArrayList<String>> getUserPaymentInfo() {
        ArrayList<String> inner;
        ArrayList<ArrayList<String>> outer = new ArrayList<>();

        try {


            PreparedStatement selectAllStatement = connectionService.getConnection().prepareStatement("SELECT * FROM customer");

            ResultSet rs = selectAllStatement.executeQuery();

            while(rs.next()){
                inner = new ArrayList<>();
                for(int i = 1; i <= 4; i++)
                {
                    inner.add(rs.getString(i));
                }
                outer.add(inner);
            }

            return outer;


        }catch (Exception e){
            e.getMessage();
        }

        return null;

    }

    @Override
    public ArrayList<ArrayList<String>> getAllCustomers() {

        ArrayList<String> inner;
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        try {


            PreparedStatement selectAllStatement = connectionService.getConnection().prepareStatement("SELECT * FROM customer");

            ResultSet rs = selectAllStatement.executeQuery();

            while(rs.next()){
                inner = new ArrayList<>();
                for(int i = 1; i <= 4; i++)
                {
                    inner.add(rs.getString(i));
                }
                outer.add(inner);
            }

            return outer;


        }catch (Exception e){
            e.getMessage();
        }

        return null;

    }
}
