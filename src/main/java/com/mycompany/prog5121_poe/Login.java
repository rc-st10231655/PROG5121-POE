/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;

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
        // Check if username has underscore and 5 11characters
        if (username.contains("_") && username.length() <= 5) {
            this.username = username; // Assign username for login
            return true;
        }
        return false;
    }
}
