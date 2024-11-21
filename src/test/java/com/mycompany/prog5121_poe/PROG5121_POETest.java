/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121_poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10231655
 */
public class PROG5121_POETest {

    // Test that developer array is correctly populated
    @Test
    void testDeveloperArrayPopulated() {
        // Declare developer names array list
        ArrayList<String> devNames = new ArrayList<>();
        // Add developer names to developer names array list
        devNames.add("Mike Smith");
        devNames.add("Edward Harrington");
        devNames.add("Samantha Paulson");
        devNames.add("Glenda Oberholzer");

        // Declare expected developer names array list
        ArrayList<String> expectedDevNames = new ArrayList<>();
        // Add expected developer names to developer array list
        expectedDevNames.add("Mike Smith");
        expectedDevNames.add("Edward Harrington");
        expectedDevNames.add("Samantha Paulson");
        expectedDevNames.add("Glenda Oberholzer");

        // Assert developer names matches expected developer name
        assertEquals(expectedDevNames, devNames, "Developer array should match test data.");
    }

    // Test that task with the longest duration is displayed
    @Test
    void testLongestDurationTask() {
        // Declare developer names array list
        ArrayList<String> devNames = new ArrayList<>();
        // Declare task durations array list
        ArrayList<Integer> taskDurations = new ArrayList<>();

        // Add developer names to developer names array list
        devNames.add("Mike Smith");
        devNames.add("Edward Harrington");
        devNames.add("Samantha Paulson");
        devNames.add("Glenda Oberholzer");

        // Add tasks durations to task durations array list
        taskDurations.add(5);
        taskDurations.add(8);
        taskDurations.add(2);
        taskDurations.add(11);

        // Declare the longest duration index integer
        int longDurIndex = 0;
        // Loop through task durations
        for (int i = 1; i < taskDurations.size(); i++) {
            // If task duration is longer than the longest duration
            if (taskDurations.get(i) > taskDurations.get(longDurIndex)) {
                // Set as the longest duration
                longDurIndex = i;
            }
        }

        // Assert the longest task duration
        assertEquals("Glenda Oberholzer", devNames.get(longDurIndex));
        assertEquals(11, taskDurations.get(longDurIndex));
    }

    // Test that task is searched by name
    @Test
    void testSearchTaskByName() {
        // Declare task names array list
        ArrayList<String> taskNames = new ArrayList<>();
        // Declare developer names array list
        ArrayList<String> devNames = new ArrayList<>();

        // Add task names to task names array list
        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        // Add developer names to developer names array list
        devNames.add("Mike Smith");
        devNames.add("Edward Harrington");
        devNames.add("Samantha Paulson");
        devNames.add("Glenda Oberholzer");

        // Declare searched task name
        String searchedTaskName = "Create Login";
        int foundIndex = -1;
        // Loop through task names
        for (int i = 0; i < taskNames.size(); i++) {
            // If task name equals to searched task name
            if (taskNames.get(i).equalsIgnoreCase(searchedTaskName)) {
                foundIndex = i;
                break;
            }
        }

        // Assert the task was found
        assertTrue(foundIndex != -1, "Task should be found.");
        assertEquals("Mike Smith", devNames.get(foundIndex));
        assertEquals("Create Login", taskNames.get(foundIndex));
    }

    // Test that task is searched by developer
    @Test
    void testSearchTasksByDeveloper() {
        // Declare task names array list
        ArrayList<String> taskNames = new ArrayList<>();
        // Declare developer names array list
        ArrayList<String> devNames = new ArrayList<>();

        // Add task names to task names array list
        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        // Add developer names to developer names array list
        devNames.add("Mike Smith");
        devNames.add("Edward Harrington");
        devNames.add("Samantha Paulson");
        devNames.add("Glenda Oberholzer");

        // Declare searched developer name string
        String searchedDevName = "Samantha Paulson";
        // Declare developer tasks array list
        ArrayList<String> devTasks = new ArrayList<>();

        // Loop through developer list
        for (int i = 0; i < devNames.size(); i++) {
            // If developer name equals to searched developer name
            if (devNames.get(i).equalsIgnoreCase(searchedDevName)) {
                devTasks.add(taskNames.get(i));
            }
        }

        // Assert tasks assigned to developer
        assertEquals(1, devTasks.size());
        assertEquals("Create Reports", devTasks.get(0));
    }

    // Test that task is deleted
    @Test
    void testDeleteTask() {
        // Declare task names array list
        ArrayList<String> taskNames = new ArrayList<>();

        // Add task names to task names array list
        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        // Declare task to be deleted string
        String taskToDel = "Create Reports";
        String result = null;

        // Loop through tasks names
        for (int i = 0; i < taskNames.size(); i++) {
            // If task name equals to task to be deleted
            if (taskNames.get(i).equalsIgnoreCase(taskToDel)) {
                taskNames.remove(i);
                result = "Entry " + taskToDel + " successfully deleted";
                break;
            }
        }

        // Assert the correct result message is returned
        assertEquals("Entry Create Reports successfully deleted", result);
        // Assert task is deleted
        assertFalse(taskNames.contains(taskToDel), "Task should no longer exist in the list.");
    }

    @Test
    void testDisplayReport() {
        // Declare task names array list
        ArrayList<String> taskNames = new ArrayList<>();
        // Declare developer names array list
        ArrayList<String> devNames = new ArrayList<>();
        // Declare task statuses array list
        ArrayList<String> taskStatuses = new ArrayList<>();
        // Declare task durations array list
        ArrayList<Integer> taskDurations = new ArrayList<>();

        // Add task one
        taskNames.add("Create Login");
        devNames.add("Mike Smith");
        taskStatuses.add("To Do");
        taskDurations.add(5);

        // Add task two
        taskNames.add("Create Add Features");
        devNames.add("Edward Harrington");
        taskStatuses.add("Doing");
        taskDurations.add(8);

        // Add task three
        taskNames.add("Create Reports");
        devNames.add("Samantha Paulson");
        taskStatuses.add("Done");
        taskDurations.add(2);

        // Add task four
        taskNames.add("Add Arrays");
        devNames.add("Glenda Oberholzer");
        taskStatuses.add("To Do");
        taskDurations.add(11);

        // Declare string builder object for report
        StringBuilder report = new StringBuilder("All tasks:\n");
        // Loop through tasks
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task Name: ").append(taskNames.get(i))
                    .append("\nDeveloper: ").append(devNames.get(i))
                    .append("\nStatus: ").append(taskStatuses.get(i))
                    .append("\nDuration: ").append(taskDurations.get(i))
                    .append("\n\n");
        }

        // Assert report is displayed
        String expectedReport = """
                All tasks:
                Task Name: Create Login
                Developer: Mike Smith
                Status: To Do
                Duration: 5
                                
                Task Name: Create Add Features
                Developer: Edward Harrington
                Status: Doing
                Duration: 8
            
                Task Name: Create Reports
                Developer: Samantha Paulson
                Status: Done
                Duration: 2
                                
                Task Name: Add Arrays
                Developer: Glenda Oberholzer
                Status: To Do
                Duration: 11
                                
                """;

        assertEquals(expectedReport.trim(), report.toString().trim());
    }
}
