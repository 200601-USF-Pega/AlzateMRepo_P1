package com.revature.onlinestoreapp.menus;
import com.revature.onlinestoreapp.service.CredentialVerification;

public class AdminLogin implements IMenu{

    private String emailPrompt = "Enter Email: ";
    private String passwordPrompt = "Enter Password: ";
    //Consider putting these in the Customer class


    String adminEmailStatement = "SELECT * FROM admin WHERE email =";
    String adminPasswordStatement = "SELECT * FROM admin WHERE password =";

    private CredentialVerification customerVerification = new CredentialVerification();
    private AdminMenu adminMenu = new AdminMenu();

    @Override
    public void start() {

        boolean email;
        boolean password;

        System.out.println("Admin Login");
        System.out.println("");

        email = customerVerification.emailVerification(emailPrompt, adminEmailStatement);
        password = customerVerification.passwordVerification(passwordPrompt, adminPasswordStatement);

        //Takes them to admin Menu if both correct
        if(email && password)
            adminMenu.start();


    }
}
