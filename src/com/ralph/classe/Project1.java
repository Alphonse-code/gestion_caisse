
package com.ralph.classe;
import java.util.*;
public class Project1 
{
    
    static Scanner console = new Scanner(System.in);
    static final String SPECIAL_CHARACTERS = "!,#,$,%,^,&,*,|";
    static String password;

    public static void main(String[] args) 
    {

        System.out.println("Create a password: ");
        password = console.next();

        if (validPassword(password))
        {
            System.out.println("Password Saved");
        }
        else
        {
            System.out.println("Invalid Passowrd. Password "
                    + "must contain atleast 1 capital letter"
                    + "1 lower case letter, 1 digit, 1"
                    + "special character (!#$%^&*|) and "
                    + "be atleast 8 characters long");
        }
    }

public static boolean validPassword(String password)
    {
        boolean upCase = false;
        boolean loCase = false;
        boolean isDigit = false;
        boolean spChar = false;

        if (password.length() >= 8)
           {
            for (int i = 0; i < password.length() - 1; i++)
               {
                if (Character.isUpperCase(password.charAt(i)))
                {
                    upCase = true;
                }

                if (Character.isLowerCase(password.charAt(i)))
                {
                    loCase = true;
                }

                if (Character.isDigit(password.charAt(i)))
                {
                    isDigit = true;
                }

                if (SPECIAL_CHARACTERS.contains(password))
                {
                    spChar = true;
                }
               } 
           }         
        return (upCase && loCase && isDigit && spChar);
    }   

}