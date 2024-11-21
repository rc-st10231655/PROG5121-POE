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
        // Declare tasks array object instance
        ArrayList<Task> taskList = new ArrayList<>();
        ArrayList<String> devNames = new ArrayList<>();
        ArrayList<String> taskNames = new ArrayList<>();
        ArrayList<String> taskIDs = new ArrayList<>();
        ArrayList<Integer> taskDurations = new ArrayList<>();
        ArrayList<String> taskStatuses = new ArrayList<>();

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



            // Declare total task hours
            int totTaskHrs = 0;
            // Declare numeric menu boolean
            boolean isMenuRunning = true;

            // While the numeric menu is running
            while (isMenuRunning) {
                // Display numeric menu
                String menuOption = JOptionPane.showInputDialog(
                        "Select an option:\n" +
                                "1) Add tasks\n" +
                                "2) Show report\n" +
                                "3) Show complete tasks\n" +
                                "4) Show longest task\n" +
                                "5) Search for a task\n" +
                                "6) Search for a developer\n" +
                                "7) Delete task\n" +
                                "8) Quit");
                // Prompt user to enter option
                int option = Integer.parseInt(menuOption);

                switch (option) {
                    case 1: {
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

                            // If task has valid description
                            if (task.checkTaskDescription()) {
                                // Display successful task message
                                JOptionPane.showMessageDialog(null, "Task successfully captured.");

                                // Add task to task list
                                taskList.add(task);

                                // Add task details to array lists
                                taskNames.add(enteredTaskName);
                                devNames.add(enteredDevName);
                                taskIDs.add(task.createTaskID());
                                taskDurations.add(enteredTaskDuration);
                                taskStatuses.add(selectedTaskStatus);

                                // Add task hours to total hours
                                totTaskHrs += task.returnTotalHours();

                                // Display task details successfully
                                JOptionPane.showMessageDialog(null, task.printTaskDetails());
                            } else {
                                // Display unsuccessful task message
                                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                            }
                        }
                        // Display total task duration
                        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totTaskHrs + " hours");
                    }
                    case 2:
                        // Declare string builder object for all tasks
                        StringBuilder allTasks = new StringBuilder("All tasks:\n");

                        // Loop through task list
                        for (int i = 0; i < taskList.size(); i++) {
                            allTasks.append("Task Name: ").append(taskNames.get(i))
                                    .append("\nTask Developer: ").append(devNames.get(i))
                                    .append("\nTask ID: ").append(taskIDs.get(i))
                                    .append("\nTask Duration: ").append(taskDurations.get(i))
                                    .append("\nTask Status: ").append(taskStatuses.get(i))
                                    .append("\n\n");
                        }
                        // Display all tasks
                        JOptionPane.showMessageDialog(null, allTasks.toString());
                        break;
                    case 3:
                        // Declare string builder object for tasks that are done
                        StringBuilder doneTasks = new StringBuilder("Done Tasks:\n");

                        // Loop through the task list
                        for (int i = 0; i < taskList.size(); i++) {
                            Task task = taskList.get(i);
                            // If task has valid description and is done
                            if (task.checkTaskDescription() && taskStatuses.get(i).equalsIgnoreCase("Done")) {
                                doneTasks.append("Developer Name: ").append(devNames.get(i))
                                        .append("\nTask Name: ").append(taskNames.get(i))
                                        .append("\nTask Duration: ").append(taskDurations.get(i))
                                        .append("\n\n");
                            }
                        }

                        // Display list of completed tasks
                        JOptionPane.showMessageDialog(null, doneTasks.toString());
                        break;
                    case 4:
                        // Declare longest duration integer
                        int longDurIndex = 0; // Longest duration index

                        // Loop through task duration list
                        for (int i = 1; i < taskDurations.size(); i++) {
                            // If task duration is longer than the longest duration
                            if (taskDurations.get(i) > taskDurations.get(longDurIndex)) {
                                // Set as the longest duration
                                longDurIndex = i;
                            }
                        }

                        // Display the longest task
                        JOptionPane.showMessageDialog(null,
                                "Developer Name: " + devNames.get(longDurIndex) + "\n" +
                                        "Task Name: " + taskNames.get(longDurIndex) + "\n" +
                                        "Task Duration: " + taskDurations.get(longDurIndex)
                        );
                        break;
                    case 5:
                        // Prompt user to enter task name to search for
                        String searchedTaskName = JOptionPane.showInputDialog("Enter Task Name to search for:");
                        // Declare found task boolean
                        boolean isTaskFound = false; // Is task found

                        // Loop through task list
                        for (int i = 0; i < taskList.size(); i++) {
                            // If task name equals to searched task name
                            if (taskNames.get(i).equalsIgnoreCase(searchedTaskName)) {
                                // Display task details
                                JOptionPane.showMessageDialog(null,
                                        "Task Name: " + taskNames.get(i) + "\n" +
                                                "Developer Name: " + devNames.get(i) + "\n" +
                                                "Task Status: " + taskStatuses.get(i) + "\n" +
                                                "Task Duration: " + taskDurations.get(i) + " hours"
                                );
                                // Task is found
                                isTaskFound = true;
                                break;
                            }
                        }
                        // If task is not found
                        if (!isTaskFound) {
                            // Display unsuccessful message if task is not found
                            JOptionPane.showMessageDialog(null, "Task not found.");
                        }
                        break;
                    case 6:
                        // Prompt user to search the developer name
                        String searchedDevName = JOptionPane.showInputDialog("Enter Developer Name to search for:");
                        // Declare string builder object for developer tasks
                        StringBuilder devTasks = new StringBuilder("Tasks assigned to " + searchedDevName + ":\n");
                        // Declare found developer boolean
                        boolean isDevFound = false; // Is developer found

                        // Loop through the developer list
                        for (int i = 0; i < devNames.size(); i++) {
                            // If developer name equals to searched developer name
                            if (devNames.get(i).equalsIgnoreCase(searchedDevName)) {
                                // Display task details
                                devTasks.append("Task Name: ").append(taskNames.get(i))
                                        .append("\nTask Status: ").append(taskStatuses.get(i))
                                        .append("\n\n");
                                // Developer is found
                                isDevFound = true;
                            }
                        }

                        // If developer is found
                        if (isDevFound) {
                            // Display the developer tasks successfully
                            JOptionPane.showMessageDialog(null, devTasks.toString());
                        } else {
                            // Display unsuccessful message if tasks not found
                            JOptionPane.showMessageDialog(null, "No developer found!");
                        }
                        break;
                    case 7:
                        // Prompt user to enter task to delete
                        String taskToDel = JOptionPane.showInputDialog("Enter Task Name to delete:");
                        // Declare deleted task boolean
                        boolean isTaskDeleted = false; // Is task deleted

                        // Loop through task list
                        for (int i = 0; i < taskList.size(); i++) {
                            // If tasks name equals to task to delete,
                            if (taskNames.get(i).equalsIgnoreCase(taskToDel)) {
                                // Delete tasks from all array lists
                                taskList.remove(i);
                                taskNames.remove(i);
                                devNames.remove(i);
                                taskIDs.remove(i);
                                taskDurations.remove(i);
                                taskStatuses.remove(i);

                                // Display that task is deleted successfully
                                JOptionPane.showMessageDialog(null, "Entry " + taskToDel + " successfully deleted.");
                                isTaskDeleted = true;
                                break;
                            }
                        }
                        // If task is not deleted
                        if (!isTaskDeleted) {
                            // Display unsuccessful message if task is not deleted
                            JOptionPane.showMessageDialog(null, "Task not found.");
                        }
                        break;
                    case 8: {
                        // Display exiting message
                        JOptionPane.showMessageDialog(null, "Exiting EasyKanban");
                        // Stop numeric menu from running
                        isMenuRunning = false;
                    }
                    default:
                        // Display invalid message
                            JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, or 3.");
                }
            }
        }
    }
}