package com.revature.onlinestoreapp.service;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionService {

    //public Connection connection;
    private static ConnectionService connectionService_single_instance = null;
    private Connection connection;

    public Connection getConnection() {

        return connection;
    }

    public static ConnectionService getInstance(){

        if(connectionService_single_instance == null) {

            connectionService_single_instance = new ConnectionService();
        }

        return connectionService_single_instance;

    }

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
