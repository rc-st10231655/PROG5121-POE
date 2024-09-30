/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ST10231655
 */
public class Login {
    /*
    Declarations
     */
    private String userFirstName; // User first name string
    private String userLastName; // User last name string
    private String userUsername; // User username string
    private String userPassword; // User Password string

    // Constructor for login
    public Login(String enteredFirstName, String enteredLastName) {
        // Assign user first name as entered first name
        this.userFirstName = enteredFirstName;
        // Assign user last name as entered last name
        this.userLastName = enteredLastName;
    }

    // Method to check username
    public boolean checkUserName(String enteredUsername) {
        // Check if username has an underscore and 5 characters maximum
        if (enteredUsername.contains("_") && enteredUsername.length() <= 5) {
            // Assign entered username as user username
            this.userUsername = enteredUsername;
            return true;
        }
        return false;
    }

    // Method to check password
    public boolean checkPasswordComplexity(String enteredPassword) {
        // Check if password has 8 characters minimum
        if (enteredPassword.length() >= 8) {
            // Declare capital letter pattern instance
            Pattern capLetterPatt = Pattern.compile("[A-Z]"); // Checks for any uppercase letter from A to Z
            // Declare number pattern object
            Pattern numPatt = Pattern.compile("[0-9]"); // Checks for any digit from 0 to 9
            // Declare special character pattern object
            Pattern specCharPatt = Pattern.compile("[^a-zA-Z0-9]"); // Checks for any character not a letter or digit

            // Declare has capital letter matcher object
            Matcher hasCapLetter = capLetterPatt.matcher(enteredPassword); // Matches capital letter pattern with password
            // Declare has number matcher object
            Matcher hasNum = numPatt.matcher(enteredPassword); // Matches number pattern with password
            // Declare has capital letter matcher object
            Matcher hasSpecChar = specCharPatt.matcher(enteredPassword); // Matches special character pattern with password

            // Checks if password has capital letter, number and special character
            if (hasCapLetter.find() && hasNum.find() && hasSpecChar.find()) {
                // Assign entered password as user password
                this.userPassword = enteredPassword;
                return true;
            }
        }
        return false;
    }

    // Method to register user and return message
    public String registerUser(String enteredUsername, String enteredPassword) {
        // Declare registration message string builder
        StringBuilder registrationMessage = new StringBuilder();

        // Check if username is correctly formatted
        if (!checkUserName(enteredUsername)) {
            // Append username incorrectly formatted message to registration messages
            registrationMessage.append("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.\n");
        }
        // Check if password is correctly formatted
        if (!checkPasswordComplexity(enteredPassword)) {
            // Append Password incorrectly formatted message to registration messages
            registrationMessage.append("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        // Check for registration message appended
        if (registrationMessage.length() > 0) {
            // Return the registration message as string
            return registrationMessage.toString();
        }

        // Assign user user name as entered username
        this.userUsername = enteredUsername;
        // Assign user password as entered password
        this.userPassword = enteredPassword;

        // Return successful registration message
        return "User registered successfully";
    }

    // Method to login user
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        // Check if entered username and password are same as user username and password
        return enteredUsername.equals(this.userUsername) && enteredPassword.equals(this.userPassword);
    }

    // Method to return login status message
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            // Return successful login message
            return "Welcome " + userFirstName + ", " + userLastName + " it is great to see you again.";
        } else {
            // Return failed login message
            return "Username or password incorrect, please try again";
        }
    }
}
