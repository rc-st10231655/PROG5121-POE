/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe;

import javax.swing.*;
import java.util.ArrayList;

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

        // Display welcome message if login successful
        if (loginStatus.contains("Welcome")) {
            // Display welcome message
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

            // Declare tasks array object instance
            ArrayList<Task> taskList = new ArrayList<>();
            // Declare total task hours
            int totTaskHrs = 0;
            // Declare numeric menu boolean
            boolean isMenuRunning = true;

            // While the numeric menu is running
            while (isMenuRunning) {
                // Display numeric menu
                String menuOption = JOptionPane.showInputDialog(
                        "Select an option:\n1) Add tasks\n2) Show report\n3) Quit");
                // Prompt user to enter option
                int option = Integer.parseInt(menuOption);

                switch (option) {
                    case 1 -> {
                        // Get the number of tasks to add
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks to add:"));

                        // For the number of tasks
                        for (int i = 0; i < numTasks; i++) {
                            // Prompt user to enter task name
                            String enteredTaskName = JOptionPane.showInputDialog("Enter task name:");
                            // Prompt user to enter task description
                            String enteredTaskDescription = JOptionPane.showInputDialog("Enter task description:");
                            // Prompt user to enter developer details
                            String enteredDevName = JOptionPane.showInputDialog("Enter developer's first and last name:");
                            // Prompt user to enter task hours
                            int enteredTaskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));

                            // Declare status options
                            String[] statusOpts = {"To Do", "Doing", "Done"};
                            // Prompt user to select task status
                            String selectedTaskStatus = (String) JOptionPane.showInputDialog(
                                    null, "Select task status:", "Task Status",
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    statusOpts, statusOpts[0]);

                            // Declare task object instance
                            Task task = new Task(enteredTaskName, i, enteredTaskDescription, enteredDevName, enteredTaskDuration, selectedTaskStatus);

                            if (task.checkTaskDescription()) {
                                // Display successful task message
                                JOptionPane.showMessageDialog(null, "Task successfully captured.");
                                // Add task to task list
                                taskList.add(task);
                                // Add task hours to total hours
                                totTaskHrs += task.returnTotalHours();
                                // Display task details
                                JOptionPane.showMessageDialog(null, task.printTaskDetails());
                            } else {
                                // Display unsuccessful task message
                                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                            }
                        }
                        // Display total task duration
                        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totTaskHrs + " hours");
                    }
                    case 2 ->
                        // Display coming soon message
                            JOptionPane.showMessageDialog(null, "Coming Soon");
                    case 3 -> {
                        // Display exiting message
                        JOptionPane.showMessageDialog(null, "Exiting EasyKanban");
                        // Stop numeric menu from running
                        isMenuRunning = false;
                    }
                    default ->
                        // Display invalid message
                            JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, or 3.");
                }
            }
        }
    }
}