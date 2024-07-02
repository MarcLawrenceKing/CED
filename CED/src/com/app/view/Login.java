/*
 * The Login class contains the GUI to present the login section.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.view;

import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class Login {
    public void login() {
        MainMenu mm = new MainMenu();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n** Login **");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (username.equals("admin") && password.equals("123")) {
            System.out.println("Login successful.");
            mm.mainmenu();
        }
    }
}
