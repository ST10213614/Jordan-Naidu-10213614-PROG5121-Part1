/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author dini
 */
public class Login_Task2 {

    // Class Variables
    private String name = "";
    private String surname = "";
    private String username = "";
    private String password = "";

   
// Constants for validation
    private final String UNDERSCORE = "_";
    private final int MAX_LENGTH = 5;
    private final int MIN_LENGTH = 8;
    private final String[] SPECIAL = {"!", "'", "#", "$", "^", "%", "&", "*", "(", ")", "_", "-", ":", ";", "<", ",", ".", "[", "]", "+", "/", ">", "?", "`", "~", "|", "{", "}", "@"};
    private final String[] CAPITAL = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"}; // array containing all captial letters
    private final String[] NUMBER = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    // check useranme for less than 5 characters and conatining an underscore
    public boolean checkUserName(String user_name) {
        boolean check = false;

        if (user_name.contains(UNDERSCORE) && user_name.length() <= MAX_LENGTH) {
            check = true;
            
        }
        return check;
    }

    // check that password contains more than 8 characters, special chracters, a capital letter
    public boolean checkPasswordComplexity(String user_password) {
        boolean check = false;
password = user_password;
        if (password.length() > MIN_LENGTH) {

            for (int j = 0; j < password.length(); j++) {
                char temporary = password.charAt(j);
                String temp = "" + temporary;

                for (int number = 0; number < NUMBER.length; number++) {

                    if (NUMBER[number].equals(temp)) {

                        // capital
                        for (int x = 0; x < password.length(); x++) {
                            temporary = password.charAt(x);
                            temp = "" + temporary;

                            for (int capital = 0; capital < CAPITAL.length; capital++) {
                                if (CAPITAL[capital].equals(temp)) {

                                    for (int y = 0; y < password.length(); y++) {
                                        temporary = password.charAt(y);
                                        temp = "" + temporary;

                                        //special
                                        for (int special = 0; special < SPECIAL.length; special++) {
                                            if (SPECIAL[special].equals(temp)) {

                                                check = true;
                                            }

                                        }

                                    }

                                }

                            }

                        }
                    }
                }
                

            }
        }
        
        return check;
    }
    
 // all class varaible getters and setters
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

        }
