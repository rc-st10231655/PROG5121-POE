/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe;

import java.util.Scanner;

/**
 *
 * @author ST10231655
 */
public class PROG5121_POE {

    // Main method
    public static void main(String[] args) {
        // Declare scanner object instance
        Scanner scannerObj = new Scanner(System.in);

        System.out.println("------ Register ------");
        // Prompt user to enter first name
        System.out.print("Enter first name: ");
        // User enters first name
        String firstName = scannerObj.nextLine();
        // Prompt user to enter last name
        System.out.print("Enter last name: ");
        // User enters last name
        String lastName = scannerObj.nextLine();

        // Declare login object instance
        Login newUser = new Login(firstName, lastName);

        // Prompt user to enter username
        System.out.print("Enter username: ");
        // User enters username
        String username = scannerObj.nextLine();
        // Prompt user to enter password
        System.out.print("Enter password: ");
        // User enters password
        String password = scannerObj.nextLine();

        // Assign registration status
        String registerStatus = newUser.registerUser(username, password);
        // Display registration status message
        System.out.println(registerStatus);

        System.out.println("------ Login ------");
        // Prompt user to enter username
        System.out.print("Enter username: ");
        // User enters last name
        String enteredUsername = scannerObj.nextLine();
        // Prompt user to enter password
        System.out.print("Enter password: ");
        String enteredPassword = scannerObj.nextLine();// User enters last name

        // Assign login status message
        String loginStatus = newUser.returnLoginStatus(enteredUsername, enteredPassword);
        // Display login status message
        System.out.println(loginStatus);

        // Close the scanner object instance
        scannerObj.close();
    }
}
