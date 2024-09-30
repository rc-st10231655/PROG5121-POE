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
    // Declarations
    private String firstName; // First name string
    private String lastName; // Last name string
    private String username; // Username string
    private String password; // Password string

    public Login() {
    }

    // Method to check username
    public boolean checkUserName(String username) {
        // Check if username has underscore and 5 characters
        if (username.contains("_") && username.length() <= 5) {
            // Assign username for login
            this.username = username;
            return true;
        }
        return false;
    }

    // Method to check password
    public boolean checkPasswordComplexity(String password) {
        // Check if password has 8 characters
        if (password.length() >= 8) {
            // Checks for any uppercase letter from A to Z
            Pattern capitalLetterPattern = Pattern.compile("[A-Z]");
            // Checks for any digit from 0 to 9
            Pattern numberPattern = Pattern.compile("[0-9]");
            // Checks for any character not a letter or digit
            Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

            // Matches capital letter pattern with password
            Matcher hasCapitalLetter = capitalLetterPattern.matcher(password);
            // Matches number pattern with password
            Matcher hasNumber = numberPattern.matcher(password);
            // Matches special character pattern with password
            Matcher hasSpecialCharacter = specialCharacterPattern.matcher(password);

            if (hasCapitalLetter.find() && hasNumber.find() && hasSpecialCharacter.find()) {
                this.password = password; // Assign password for login
                return true;
            }
        }
        return false;
    }
}
