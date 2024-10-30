/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe;

import javax.swing.*;

/**
 *
 * @author ST10231655
 */
public class PROG5121_POE {

    public static void main(String[] args) {
        // Prompt user to enter first name
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        // Prompt user to enter last name
        String lastName = JOptionPane.showInputDialog("Enter last name:");

        // Declare login instance
        Login newUser = new Login(firstName, lastName);

        // Prompt user to enter username
        String username = JOptionPane.showInputDialog("Enter username:");
        // Prompt user to enter password
        String password = JOptionPane.showInputDialog("Enter password:");

        String registerStatus = newUser.registerUser(username, password);
        // Display registration status
        JOptionPane.showMessageDialog(null, registerStatus);

        // Prompt user to enter username
        String enteredUsername = JOptionPane.showInputDialog("Enter username:");
        // Prompt user to enter password
        String enteredPassword = JOptionPane.showInputDialog("Enter password:");

        String loginStatus = newUser.returnLoginStatus(enteredUsername, enteredPassword);
        // Display login status
        JOptionPane.showMessageDialog(null, loginStatus);
    }
}