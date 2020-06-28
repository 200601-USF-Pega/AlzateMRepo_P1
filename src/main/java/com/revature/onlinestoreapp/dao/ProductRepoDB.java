package com.revature.onlinestoreapp.dao;

import com.revature.onlinestoreapp.models.Cart;
import com.revature.onlinestoreapp.models.LineItems;
import com.revature.onlinestoreapp.models.OrderTotal;
import com.revature.onlinestoreapp.models.Product;
import com.revature.onlinestoreapp.web.ConnectionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.log4j.Logger;

import javax.sound.sampled.Line;

public class ProductRepoDB implements IProductRepo {


    private ConnectionService connectionService = ConnectionService.getInstance();
    final static Logger logger = Logger.getLogger(ProductRepoDB.class);

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


            logger.info("New product added: " + product);
            return product;

        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            logger.error("Failed to add product: " + product);
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
    public Cart enterCart(Cart cart) {

        ResultSet rs = null;

        try{

            PreparedStatement enterCartStatement =
                    connectionService.getConnection().prepareStatement("INSERT INTO cart (customer_id) VALUES (?)");

            enterCartStatement.setInt(1, cart.getCustomer_id());


            enterCartStatement.executeUpdate();
            System.out.println("Cart added to DB");

            rs = enterCartStatement.getGeneratedKeys();
            if(rs != null && rs.next()){
                System.out.println("Generated Key: " + rs.getInt(1));
            }

            return cart;



        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public LineItems addLineItem(LineItems items){

        try{

            PreparedStatement addLineItemStatement =
                    connectionService.getConnection().prepareStatement("INSERT INTO LineItems (cart_id, product_id, quantity) VALUES (?, ?, ?)");

            addLineItemStatement.setInt(1, items.getCart_id());
            addLineItemStatement.setInt(2, items.getProduct_id());
            addLineItemStatement.setInt(3, items.getQuantity());

            addLineItemStatement.executeUpdate();

            System.out.println("Line Items added successfully");

            return items;


        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public ArrayList<OrderTotal> totalOrder() {
        ArrayList<OrderTotal> result = new ArrayList<>();

        try {

            PreparedStatement totalOrder =
                    connectionService.getConnection().prepareStatement
                            ("SELECT c.cart_id, ROUND(SUM(s.price * l.quantity)) AS TOTAL " +
                                    "FROM cart c, lineitems l, products s " +
                                    "WHERE c.cart_id = l.cart_id AND l.product_id = s.product_id " +
                                    "GROUP BY c.cart_id");


            ResultSet resultSet = totalOrder.executeQuery();


            while(resultSet.next()) {

                //double total = resultSet.getDouble("total");
                //System.out.println("Total Price: " + total);
                OrderTotal orderTotal = new OrderTotal(resultSet.getDouble("total"));
                result.add(orderTotal);


            }
            return result;

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

        return null;

    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> result = new ArrayList<>();
        try {


            PreparedStatement selectAllStatement =
                    connectionService.getConnection().prepareStatement("SELECT * FROM products");

            ResultSet rs = selectAllStatement.executeQuery();

            while(rs.next()){

                Product product = new
                        Product(rs.getInt("product_id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"));
                result.add(product);

            }

            return result;

        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }
}
