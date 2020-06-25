package com.revature.onlinestoreapp.web;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionService {

    private static ConnectionService connectionService_single_instance = null;
    public static Connection connection;


    public static void initialize() {
        try  {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(MyProps.url, MyProps.name, MyProps.password);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        if(connection == null){
            initialize();

        }
        return connection;
    }

    //P0
    public static ConnectionService getInstance(){

        if(connectionService_single_instance == null) {

            connectionService_single_instance = new ConnectionService();
        }

        return connectionService_single_instance;

    }

    //P0
    public ConnectionService() {
        try {
            FileInputStream file = new FileInputStream("connection.prop");

            Properties p = new Properties();
            p.load(file);
            connection = DriverManager.getConnection(p.getProperty("hostname"),
                    p.getProperty("username"),p.getProperty("password"));

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();

        }

    }



    @Override
    public void finalize() {
        try {

            connection.close();

        } catch (Exception e){
            e.getMessage();

        }

    }

}
