/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jordz
 */
public class Login {

    public boolean checkUserName(String username) {
        String usernam = username;
        int count = 0;
        boolean user = false;

        if (usernam.contains("_")) { // check if username conatins an underscore
            if (usernam.length() <= 5) { // check if username is less than 5 characters 

                count++;
                user = true;
            
            } else {
                user = false;
            }
        } else {
            user = false;
        }

        return user;

    }

    public Boolean checkPasswordComplexity(String password) {
        String code = password;
        boolean pass = false;

        String[] special = {"!", "'", "#", "$", "^", "%", "&", "*", "(", ")", "_", "-", ":", ";", "<", ",", ".", "[", "]", "+", "/", ">", "?", "`", "~", "|", "{", "}", "@"}; // array conatining all special characters
        String[] capital = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"}; // array containing all captial letters
        String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}; // array conatining all numbers
        String temp = "";
        int count = 0;

        if (code.length() >= 8) { // see if password has more than 8 charcacters 
            // number
            for (int j = 0; j < code.length(); j++) {
                char c = code.charAt(j);
                temp = "" + c;

                for (int i = 0; i < 9; i++) {
                    if (number[i].equals(temp)) {

                        j = code.length();
                        i = 9;
                        count++;
                        // capital
                        for (int x = 0; x < code.length(); x++) {
                            c = code.charAt(x);
                            temp = "" + c;

                            for (int y = 0; y < 26; y++) {
                                if (capital[y].equals(temp)) {

                                    x = code.length();
                                    y = 26;
                                    count++;
                                    //special
                                    for (int h = 0; h < code.length(); h++) {
                                        c = code.charAt(h);
                                        temp = "" + c;

                                        for (int k = 0; k < 29; k++) {
                                            if (special[k].equals(temp)) {

                                                h = code.length();
                                                k = 29;
                                                count++;
                                            }

                                        }

                                    }

                                }

                            }

                        }
                    } //end if
                }//end for i
            } //end for j
        }// end if
        if (count < 3) {
            pass = false;

            count = 0;
        } else {
            pass = true;

        }

        return pass;
    }

    public String registerUser(boolean user, boolean password) {
        String temp = "";
        if (user == false && password == true) {
            temp = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        } else if (user == true && password == false) {
            temp = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else if (user == false && password == false) {
            temp = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length \n Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else if (user == true && password == true) {
            temp = "You have been succesfully registered";
        }
        return temp;
    }

    public Boolean loginUser(String rUser, String lUser, String rPassword, String lPassword) {
        boolean login = false;
        if (lUser.equals(rUser) && lPassword.equals(rPassword)) { // compares registartion details to login details
            login = true;
        } else {
            login = false;
        }
        return login;
    }

    public String returnLoginStatus(String name, String surname, boolean result) {
        String temp = "";
        if (result == true) {
            temp = "Welcome " + name + ", " + surname + " it is great to see you again";
        } else {
            temp = "Username or Password incorrect please try again";
        }
        return temp;
    }
}
