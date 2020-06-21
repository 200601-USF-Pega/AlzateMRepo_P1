package com.revature.onlinestoreapp.service;
import java.util.Scanner;

public class ValidationService {

    Scanner input = new Scanner(System.in);

    boolean invalid = true;

    public String getValidStringInput(String prompt) {
        String userInput;

        do {

            System.out.println(prompt);
            userInput = input.nextLine();

            if(!userInput.isEmpty())
                break;
            System.out.println("Please input non empty string");

        } while(invalid);

        return userInput;
    }

    //Will use this when admin is adding price to items
    public int getValidInt(String prompt) {
        int userInput = 0;
        do {
            System.out.println(prompt);
            try {
                userInput = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please input valid integers");
            }
        } while(invalid);
        return userInput;
    }

    public double getValidDouble(String prompt) {
        double userInput = 0;
        do {
            System.out.println(prompt);
            try {
                userInput = Double.parseDouble(input.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please input valid double");
            }
        } while(invalid);
        return userInput;
    }

}
