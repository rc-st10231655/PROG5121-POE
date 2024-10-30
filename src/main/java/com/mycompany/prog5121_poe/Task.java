/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe;

/**
 *
 * @author ST10231655
 */
public class Task {
    private String taskName; // Task name string
    private int taskNum; // Task number integer
    private String taskDescription; // Task description string
    private String devDetails; // Task developer details string
    private int taskDuration; // Task duration integer
    private String taskID; // Task ID string
    private String taskStatus; // Task status string

    // Task constructor
    public Task(String taskName, int taskNum, String taskDescription, String devDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNum = taskNum;
        this.taskDescription = taskDescription;
        this.devDetails = devDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus;
    }

    // Method to check task description length
    public boolean checkTaskDescription() {
        // Return task description if length is less than 50
        return this.taskDescription.length() <= 50;
    }

    // Method to create Task ID
    public String createTaskID() {
        // First two letters of task name
        String firstTwoLetters = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
        // Last three letters of task developer
        String lastThreeLetters = devDetails.length() >= 3 ? devDetails.substring(devDetails.length() - 3) : devDetails;
        // Return task ID
        return (firstTwoLetters + ":" + taskNum + ":" + lastThreeLetters).toUpperCase();
    }

    // Method to print task details
    public String printTaskDetails() {
        // Display task details
        return "Task Status: " + taskStatus + "\n"
                + "Developer Details: " + devDetails + "\n"
                + "Task Number: " + taskNum + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskID + "\n"
                + "Duration: " + taskDuration + " hours";
    }

    // Method to return task duration
    public int returnTotalHours() {
        // Return task duration
        return this.taskDuration;
    }
}