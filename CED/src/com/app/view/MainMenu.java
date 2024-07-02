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
public class MainMenu {

    public void mainmenu() {
        Login lg = new Login();
        CRUDMenu cm = new CRUDMenu();
        GenerateCOR gc = new GenerateCOR();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n** Options **");
        System.out.println("[C] Create record");
        System.out.println("[R] Read record");
        System.out.println("[U] Update record");
        System.out.println("[D] Delete record");
        System.out.println("[G] Generate COR");
        System.out.println("[L] Logout");
        System.out.println("[X] Exit Program");
        System.out.print("Enter your choice: ");
        char choice = sc.next().toLowerCase().charAt(0);

        switch (choice) {
            case 'c':
                cm.createMenu();
                break;
            case 'r':
                cm.readMenu();
                break;
            case 'u':
                cm.updateMenu();
                break;
            case 'd':
                cm.deleteMenu();
                break;
            case 'g':
                gc.generateCOR();
                break;
            case 'l':
                System.out.println("Logout successfull.");
                lg.login();
                break;
            case 'x':
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                System.out.println("Enter a valid choice. ");
                mainmenu();
                break;
        }

    }
}
