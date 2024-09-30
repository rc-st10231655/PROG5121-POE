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

}
