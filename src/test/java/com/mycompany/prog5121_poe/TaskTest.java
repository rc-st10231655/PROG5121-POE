/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121_poe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10231655
 */
// Task test class
public class TaskTest {
    private Task taskOne;
    private Task taskTwo;

    @BeforeEach
    public void setUp() {
        // Create task one
        taskOne = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        // Create task two
        taskTwo = new Task("Add Task Feature", 2, "Create Add Task feature to add task users", "Mike Smith", 10, "To Do");
    }

    @Test
    // Test if task description length is successful
    public void testTaskDescriptionLengthSuccess() {
        assertTrue(taskOne.checkTaskDescription(), "Task description should not exceed 50 characters");
        assertTrue(taskTwo.checkTaskDescription(), "Task description should not exceed 50 characters");
    }

    @Test
    // Test if task description length is unsuccessful
    public void testTaskDescriptionLengthFailure() {
        Task taskThree = new Task("Long Description Task", 3, "This task description is intentionally made too long to exceed the limit of fifty characters", "Developer", 5, "To Do");
        assertFalse(taskThree.checkTaskDescription(), "Please enter a task description of less than 50 characters");
    }

    @Test
    // Test if task IDS are generated
    public void testTaskIDGeneration() {
        assertEquals("LO:1:SON", taskOne.createTaskID(), "TaskID for Task 1 should be correctly generated.");
    }

    @Test
    // Test if task IDs generate in loop
    public void testTaskIDLoopGeneration() {
        // Declare tasks to check task ID
        Task taskThree = new Task("Create", 0, "A", "Rob", 5, "To Do");
        Task taskFour = new Task("Create", 1, "A", "Harrison", 5, "To Do");
        Task taskFive = new Task("Create", 2, "A", "Smith", 5, "To Do");
        Task taskSix = new Task("Create", 3, "A", "Johnson", 5, "To Do");

        // Assert that task IDs are expected
        assertEquals("CR:0:ROB", taskThree.createTaskID());
        assertEquals("CR:1:SON", taskFour.createTaskID());
        assertEquals("CR:2:ITH", taskFive.createTaskID());
        assertEquals("CR:3:SON", taskSix.createTaskID());
    }

    @Test
    // Test if task total hours accumulate
    public void testTotalHoursAccumulation() {
        // Task total hours test data
        Task taskSeven = new Task("taskOne", 0, "Description1", "Dev1", 10, "To Do");
        Task taskEight = new Task("taskTwo", 1, "Description2", "Dev2", 12, "To Do");
        Task taskNine = new Task("taskThree", 2, "Description3", "Dev3", 55, "To Do");
        Task taskTen = new Task("taskFour", 3, "Description4", "Dev4", 11, "To Do");
        Task taskEleven = new Task("taskFive", 4, "Description5", "Dev5", 1, "To Do");

        // Calculate total hours
        int totHrs = taskSeven.returnTotalHours() + taskEight.returnTotalHours() + taskNine.returnTotalHours()
                + taskTen.returnTotalHours() + taskEleven.returnTotalHours();

        // Assert that total hours are 89
        assertEquals(89, totHrs, "Total hours should equal 89 for additional test data.");
    }

    @Test
    // Test if task loop accumulates
    public void testLoopAccumulation() {
        // Declare total hours
        int totHrs = 0;
        // Add task one hours
        totHrs += taskOne.returnTotalHours();
        // Add task two hours
        totHrs += taskTwo.returnTotalHours();

        // Assert that total hours are 18
        assertEquals(18, totHrs, "Total hours should equal 18 for the initial test data.");
    }
}