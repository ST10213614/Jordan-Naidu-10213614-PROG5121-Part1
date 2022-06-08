/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;

/**
 *
 * @author dini
 */
public class LoginTest {
    public LoginTest()
    {
    }
    
   @Test
    public void testCheckPasswordComplexity()
    {
        Login_Task1 instance = new Login_Task1();
        boolean result, expResult;
        String str;
        //-------------------------------------------------
        System.out.println("checkPasswordComplexity - Ch&&sec@ke99!");
        str = "Ch&&sec@ke99!";
        expResult = true;
        result = instance.checkPasswordComplexity(str);
        assertEquals(expResult, result);
        //-------------------------------------------------
        System.out.println("checkPasswordComplexity - password");
        str = "password";
        expResult = false;
        result = instance.checkPasswordComplexity(str);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckUserName()
    {
        Login_Task1 instance = new Login_Task1();
        boolean result, expResult;
        String str;
        //-------------------------------------------------
        System.out.println("checkUserName - kyl_1");
        str = "kyl_1";
        expResult = true;
        result = instance.checkUserName(str);
        assertEquals(expResult, result);
        //-------------------------------------------------
        System.out.println("checkUserName - kyle!!!!!!!");
        str = "kyle!!!!!!!";
        expResult = false;
        result = instance.checkUserName(str);
        assertEquals(expResult, result);
    }
    
}
 

