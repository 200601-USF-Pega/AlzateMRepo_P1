package com.revature.onlinestoreapp.dao;

import com.revature.onlinestoreapp.models.Product;
import com.revature.onlinestoreapp.service.ConnectionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepoDB implements IProductRepo {


    private ConnectionService connectionService = ConnectionService.getInstance();

    public ProductRepoDB(){


    }


    @Override
    public Product addProduct(Product product) {

        try{

            PreparedStatement addProductStatement = connectionService.getConnection().prepareStatement("INSERT INTO products " +
                    "(name, price, description) VALUES(?, ?, ?)");

            addProductStatement.setString(1, product.getName());
            addProductStatement.setDouble(2, product.getPrice());
            addProductStatement.setString(3, product.getDescription());

            addProductStatement.executeUpdate();


            return product;

        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public void removeProduct(int id) {

        try {

            PreparedStatement removeStatement =
                    connectionService.getConnection().prepareStatement("DELETE FROM products WHERE product_id = ?");

            removeStatement.setInt(1, id);


            removeStatement.executeUpdate();
            System.out.println("Success");
            //System.out.println("Removed: "+ product.toString());

            //return true;

        } catch (Exception e) {

            e.getMessage();

        }

        //return false;

    }

    @Override
    public void enterCart(int customerID) {

        try{

            PreparedStatement enterCartStatement =
                    connectionService.getConnection().prepareStatement("INSERT INTO cart (customer_id) VALUES (?)");

            enterCartStatement.setInt(1, customerID);


            enterCartStatement.executeUpdate();

            PreparedStatement selectFromCart =
                    connectionService.getConnection().prepareStatement("SELECT * FROM cart WHERE customer_id =" + "'" + customerID + "'");

            ResultSet resultSet = selectFromCart.executeQuery();

            if (resultSet.next()) {



                int cartID = resultSet.getInt(1);

                System.out.println("Cart ID: " + cartID);



            } else {
                System.out.println("Fail");
            }


        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void addLineItem(int cartID, int productID, int quantity){

        try{

            PreparedStatement addLineItemStatement =
                    connectionService.getConnection().prepareStatement("INSERT INTO LineItems (cart_id, product_id, quantity) VALUES (?, ?, ?)");

            addLineItemStatement.setInt(1, cartID);
            addLineItemStatement.setInt(2, productID);
            addLineItemStatement.setInt(3, quantity);

            addLineItemStatement.executeUpdate();


        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }


    }

    @Override
    public void totalOrder() {

        try {

            PreparedStatement totalOrder =
                    connectionService.getConnection().prepareStatement
                            ("SELECT c.cart_id, ROUND(SUM(s.price * l.quantity)) AS TOTAL " +
                                    "FROM cart c, lineitems l, products s " +
                                    "WHERE c.cart_id = l.cart_id AND l.product_id = s.product_id " +
                                    "GROUP BY c.cart_id");


            ResultSet resultSet = totalOrder.executeQuery();


            if (resultSet.next()) {

                //int customer_id = resultSet.getInt("customer_id");
                //String email = resultSet.getString("email");

                double total = resultSet.getDouble("total");

                System.out.println("Total Price: " + total);


            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

    }

    @Override
    public ArrayList<ArrayList<String>> getAllProducts() {
        ArrayList<String> inner;
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        try {


            PreparedStatement selectAllStatement = connectionService.getConnection().prepareStatement("SELECT * FROM products");

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
