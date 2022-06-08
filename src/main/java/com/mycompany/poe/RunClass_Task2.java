/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dini
 */
public class RunClass_Task2 {

    // CONSTANT FOR ARRAY SIZE
    final static int USERS = 10;
final static int FEATURES = 20; 

//Class variables
    Login_Task2 user[] = new Login_Task2[USERS]; // array for users 
AddFeatures_Task2 feature[] = new AddFeatures_Task2[FEATURES]; // array for features
    
static int numReg = 0; // keeps track of registered users
static int numLog = 0; // tracks currently logged in users
  
//Method to display Register/Login menu
public int printLoginMenu()
    
 {
        int selection = 0;
        boolean valid = false; // ALWAYS ASSUME INVALID INPUT     
        boolean loggedin;
        while (valid != true)
        {
             selection = Integer.parseInt(JOptionPane.showInputDialog("Please enter a selection: \n" + "1. Register user\n" +"2. Login User\n" + "3. Quit\n" +"Registered users : " + numReg));
           
            if ((selection < 1) || (selection > 3)) // selection not in the range
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid selection [1 to 3]"); // error message
            }
            else 
            {
                valid = true;
            }
        }
        while(selection != 3 ){
            switch(selection){
                case 1: 
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Goodbye");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
            }
        }
        
       
                
        
        return selection;
        
    }

// method to capture a check registration
    public void registerUser() {

        String username = "";
        String password = "";
        String name = "";
        String surname = "";
        

        Login_Task2 NEW_USER = new Login_Task2(); //temporary user to add to array
        boolean valid = false; // ASSUME INVALID INPUT

       
        do {
            username = JOptionPane.showInputDialog("Enter wanted Username \n Maxiumum 5 characters \n Must contain '_' ");

            if (NEW_USER.checkUserName(username)) {
                valid = true;
            } else {
                JOptionPane.showMessageDialog(null, ("Username is not correctly formatted,\n"
                        + "please ensure that your username contains\n"
                        + "an underscore and is no more than 5 characters\n"
                        + "in length."));
            }
        } while (valid != true);

        NEW_USER.setUsername(username); // CAPTURE THE VALID USERNAME
        JOptionPane.showMessageDialog(null, "Username succesfully captured");

        valid = false; //  ASSUME INVALID INPUT FOR NEXT CRITERIA
         
        password = JOptionPane.showInputDialog("Enter wanted Password \n Miniumum 8 characters \n Must contain Captial \n Must contain Special: ");
        while(valid == false){
           

            if (NEW_USER.checkPasswordComplexity(password)) {
                valid = true;
            } 
            
            else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted,\n"
                        + "please ensure that the password\n"
                        + "contains at least 8 characters,\n"
                        + "a capital letter, a number and a\n"
                        + "special character.");
                password = JOptionPane.showInputDialog("Enter wanted Password \n Miniumum 8 characters \n Must contain Captial \n Must contain Special: ");
            }
        } 

        NEW_USER.setPassword(password); // CAPTURE THE VALID PASSWORD
        JOptionPane.showMessageDialog(null, "Password succesfully captured");

        name = JOptionPane.showInputDialog("Enter FirstName : "); 

        NEW_USER.setName(name); // CAPTURE THE USER FIRST NAME

        surname = JOptionPane.showInputDialog("Enter Surname : "); 

        NEW_USER.setSurname(surname); // CAPTURE THE USER SURNAME
     
        user[numReg] = NEW_USER; // ADD THE NEW USER TO THE ARRAY
        numReg++; // KEEP TRACK OF HOW MANY USERS HAVE REGISTERED

        JOptionPane.showMessageDialog(null, "User successfully registered");
        mainThread();
    }

 // method to see if user as registered credentials   
    public boolean loginUser() {
        boolean valid = false; // Assume Invalid
        
       

       String username = JOptionPane.showInputDialog("Enter your Username: ");
        
       String password = JOptionPane.showInputDialog("Enter your Password: ");
      
        for (int w = 0; w < numReg; w++) {
            
            if (user[w].getUsername().equals(username)) {
               
                
                if (user[w].getPassword().equals(password)) {
                    valid = true;
                    numLog = w; // SET USER ARRAY INDEX   
                
            }
            
        }
       
     }
     
         
        return valid;
    }


   // Method to display task options 
    public void menu() {
        int option = Integer.parseInt(JOptionPane.showInputDialog("Please choose from one of the following options \n  1) Add Task \n 2) Show report \n 3) Quit"));

        while (option != 3) {
            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null,"Coming soon");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Thank you");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Please enter a valid option");
            }
        }
    }
// method to add tasks
    public void addTask() {
        int numTask = 0;
       

        numTask = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add"));

        for (int x = 0; x < numTask; x++) {
            taskDevelopment(x);
        }
        JOptionPane.showMessageDialog(null, "Tasks Captured");

       

    }
//method to develop tasks
    public void taskDevelopment(int x) {
        //temporary task variables
        String taskName, descrip, devloper, ID;
        int duration, status;
boolean valid = false;
        AddFeatures_Task2 add = new AddFeatures_Task2();
        // used to get correct array index
        int incr = AddFeatures_Task2.getIncrTask();
       taskName = JOptionPane.showInputDialog("Enter the name of the " +(x+1) + " task");
        descrip = JOptionPane.showInputDialog("Enter a short description for the task (must not exceed more than characters");
      while(add.checkTaskDescription(descrip) == false)  
         {
            descrip = JOptionPane.showInputDialog("Enter a short description for the task (must not exceed more than characters");

            JOptionPane.showMessageDialog(null, "Please enter a task description less that 50 characters");

        } 
        
    devloper = JOptionPane.showInputDialog("Enter the Developers Fisrt Name and Surname");
    duration =   Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of tasks"));
    
    status = Integer.parseInt(JOptionPane.showInputDialog("Select an Option for Task Status \n 1 - To Do \n 2 - Doing \n 3 - Done"));
        System.out.println(status);
    
    while(status <1 || status >3) // check if option is in range
    { 
        JOptionPane.showMessageDialog(null, "Value can only be choice 1, 2 or 3");
        status = Integer.parseInt(JOptionPane.showInputDialog("Select an Option for Task Status \n 1 - To Do \n 2 - Doing \n 3 - Done"));    
    } 
 
        
    ID = add.createTaskID( taskName,  incr,  devloper);
    

    add.setTaskNum();// set the task number(also increments for next task)
    add.setTaskID(ID);// set task ID 
    add.setTaskName(taskName);// set the task name
    add.setTaskDesc(descrip);// set task description
    add.setDevDet(devloper);// set developer details
    add.setTaskDur(duration);// set task duration (also adds to total durations)
    add.setTaskStatus((status-1));// set the task status minus 1 to build array
       
    JOptionPane.showMessageDialog(null, add.printTaskDetails());// display the ALL the task details

    feature[incr] = add; // add new task to the array
    }
 
    // main features thread
     public void mainThread()
     {

         int selection = Integer.parseInt(JOptionPane.showInputDialog("Please enter a selection: \n" + "1. Register user\n" +"2. Login User\n" + "3. Quit\n" +"Registered users : " + numReg));
        
         boolean loggedin ;
          while(selection !=3){
        switch(selection){
            case 1:
                registerUser();
                break;
            case 2:
                loggedin = loginUser();
                if (loggedin == false){
                    JOptionPane.showMessageDialog(null, "Username or password incorrect please try again");
                    loginUser();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Welcome" + user[numLog].getName() + " " + user[numLog].getSurname() + " its great to see you");
                menu();
                }
                
              
                break;
        }   
        }
     }
    
}
    



