/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author dini
 */
public class FeaturesTest {
  final int MAX_TASKS = 10;
    AddFeatures_Task2 testTask = new AddFeatures_Task2();
    AddFeatures_Task2[] testArray = new AddFeatures_Task2[MAX_TASKS];
    
    public FeaturesTest()
    {
        
    }

   public void populateArray()
    {
         String taskID = "";
         String[] taskNames =  {"Create Login", "Create Add Feature",
                                "Create Reports", "Add Arrays"};
         String[] taskDescr =  {"Login Facility", "Add Task Facility",
                                "Report Facility", "Search Facility"};
         String[] devDetails = {"Mike Smith","Edward Harrington",
                                "Samantha Paulson", "Glenda Oberholzer"};
         int[] taskDurations = {5,8,2,11}; 
         int[] taskStatus    = {0,1,2,0}; // 0 = To Do, 1 = Doing, 2 = Done
         
         for (int counter = 0; counter < taskNames.length; counter++)
         {
             taskID = testTask.createTaskID(taskNames[counter], 
                                   Task.getIncrementTaskNumber(), 
                                   devDetails[counter]);
             testTask.setValidTask(true);
             testTask.setTaskNumber();
             testTask.setTaskID(taskID);
             testTask.setTaskName(taskNames[counter]);
             testTask.setTaskDescription(taskDescr[counter]);
             testTask.setDeveloperDetails(devDetails[counter]);
             testTask.setTaskDuration(taskDurations[counter]);
             testTask.setTaskStatus(taskStatus[counter]);
             testArray[counter] = testTask;
         }
    }
   
@Test 
    public void testReturnTotalHours()
    {
        System.out.print("Checking total hours exp - 26 ");
        populateArray();
        int expected = 26; // 5 + 8 + 2 + 11 = 26 (not 18 given the test data)
        int actual = testTask.returnTotalHours();
        assertEquals(expected,actual);
        System.out.println(" - " + actual);
        //----------------------------------------just proof of concept [delete]
        System.out.print("Checking Hours changed after delete exp - 15");
        testArray[3].setValidTask(false);
        expected = 15; 
        actual = testTask.returnTotalHours();
        assertEquals(expected,actual);
        System.out.println(" - " + actual);
    }
    
@Test
    public void testCreateTaskID()
    {
        String expected = "AD:1:BYN";
        String actual = testTask.createTaskID("Add login Feature", 1, "Robyn");
        assertEquals(expected,actual);
                   
    }
@Test
    public void testCreateTaskIDinLoop()
    {
          String [] developerNames = new String[] {"Mike","Edward", "Samantha", "Glenda"};
         
          String [] taskNames ={"Create Login", "Create Add Tasks",
              "Create Report", "Create Search"};
         
          String [] testIDs = {"CR:0:IKE","CR:1:ARD","CR:2:THA","CR:3:NDA"};
         
          for (int i = 0; i < developerNames.length; i++)
          {
             String expected =  testIDs[i];
             String actual = testTask.createTaskID(taskNames[i], i, developerNames[i] );
             assertEquals(expected,actual);
          }
    }
}
  }
