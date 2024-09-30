/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121_poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10231655
 */
// Login test class
public class LoginTest {

    // Test username is correctly formatted
    @Test
    public void testUsernameCorrectlyFormatted() {
        Login user = new Login("John", "Doe");
        String registrationResult = user.registerUser("kyl_1", "Valid@Password1");
        assertEquals("User registered successfully", registrationResult);
        String loginStatus = user.returnLoginStatus("kyl_1", "Valid@Password1");
        assertEquals("Welcome John, Doe it is great to see you again.", loginStatus);
    }

    // Test username is incorrectly formatted
    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login user = new Login("John", "Doe");
        String result = user.registerUser("kyle!!!!!!!", "Valid@Password1");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.\n", result);
    }

    // Test password meets the complexity requirements
    @Test
    public void testPasswordMeetsComplexity() {
        Login user = new Login("John", "Doe");
        String result = user.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("User registered successfully", result);
    }

    // Test password does not meet the complexity requirements
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login user = new Login("John", "Doe");
        String result = user.registerUser("kyl_1", "password");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    // Test successful login
    @Test
    public void testSuccessfulLogin() {
        Login user = new Login("John", "Doe");
        user.registerUser("kyl_1", "Valid@Password1");
        assertTrue(user.loginUser("kyl_1", "Valid@Password1"));
        assertEquals("Welcome John, Doe it is great to see you again.", user.returnLoginStatus("kyl_1", "Valid@Password1"));
    }

    // Test failed login
    @Test
    public void testFailedLogin() {
        Login user = new Login("John", "Doe");
        user.registerUser("kyl_1", "Valid@Password1");
        assertFalse(user.loginUser("kyl_1", "WrongPassword"));
        assertEquals("Username or password incorrect, please try again", user.returnLoginStatus("kyl_1", "WrongPassword"));
    }

    // Test username correctly formatted
    @Test
    public void testUsernameFormattedCorrectly() {
        Login user = new Login("John", "Doe");
        assertTrue(user.checkUserName("kyl_1"));
    }


}
