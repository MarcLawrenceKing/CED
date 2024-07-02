/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class Login {
    public void login () {
        MainMenu mm = new MainMenu();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n** Login **");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        if(username.equals("admin") && password.equals("123")){
            System.out.println("Login successful.");
            mm.mainmenu();
        }
    }
}
