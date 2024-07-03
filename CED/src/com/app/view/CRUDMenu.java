/*
 * The CRUDMenu class contains the GUI to present all CRUD options.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.view;

import java.util.Scanner;

public class CRUDMenu {

    public void createMenu() {
        MainMenu mm = new MainMenu();
        CreateMenu cm = new CreateMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n** Create Menu **");
        System.out.println("[1] Create AY Term record");
        System.out.println("[2] Create Enrollment record");
        System.out.println("[3] Create Schedule record");
        System.out.println("[4] Create Section record");
        System.out.println("[5] Create Student record");
        System.out.println("[6] Create Tuition record");
        System.out.println("[7] Create TuitionFees record");
        System.out.println("[8] Back");
        System.out.print("Enter your choice: ");
        char choice = sc.next().charAt(0);

        switch (choice) {
            case '1':
                cm.createAYTerm();
                break;
            case '2':
                cm.createEnrollment();
                break;
            case '3':
                cm.createSchedule();
                break;
            case '4':
                cm.createSection();
                break;
            case '5':
                cm.createStudent();
                break;
            case '6':
                cm.createTuition();
                break;
            case '7':
                cm.createTuitionFees();
                break;
            case '8':
                mm.mainmenu();
                break;
            default:
                System.out.println("Invalid choice.");
                createMenu();
                break;
        }
    }

    public void readMenu() {
        MainMenu mm = new MainMenu();
        ReadMenu rm = new ReadMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n** Read Menu **");
        System.out.println("[1] Read AY Term records");
        System.out.println("[2] Read Enrollment records");
        System.out.println("[3] Read Fees records");
        System.out.println("[4] Read Program records");
        System.out.println("[5] Read Schedule records");
        System.out.println("[6] Read Scholarship record");
        System.out.println("[7] Read Section record");
        System.out.println("[8] Read Student record");
        System.out.println("[9] Read Subject records");
        System.out.println("[10] Read Tuition record");
        System.out.println("[11] Read Tuition-Fees records");
        System.out.println("[12] Back");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                rm.readAYTerm();
                break;
            case 2:
                rm.readEnrollment();
                break;
            case 3:
                rm.readFees();
                break;
            case 4:
                rm.readProgram();
                break;
            case 5:
                rm.readSchedule();
                break;
            case 6:
                rm.readScholarship();
                break;
            case 7:
                rm.readSection();
                break;
            case 8:
                rm.readStudent();
                break;
            case 9:
                rm.readSubject();
                break;
            case 10:
                rm.readTuition();
                break;
            case 11:
                rm.readTuitionFees();
                break;
            case 12:
                mm.mainmenu();
                break;
            default:
                System.out.println("Invalid choice.");
                createMenu();
                break;
        }
    }

    public void updateMenu() {
        MainMenu mm = new MainMenu();
        UpdateMenu um = new UpdateMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n** Update Menu **");
        System.out.println("[1] Update Schedule records");
        System.out.println("[2] Update Student record");
        System.out.println("[3] Back");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                um.updateSchedule();
                break;
            case 2:
                um.updateStudent();
                break;
            case 3:
                mm.mainmenu();
                break;
            default:
                System.out.println("Invalid choice.");
                updateMenu();
                break;
        }
    }

    public void deleteMenu() {
        MainMenu mm = new MainMenu();
        DeleteMenu dm = new DeleteMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n** Delete Menu **");
        System.out.println("[1] Delete Enrollment records");
        System.out.println("[2] Delete Tuition-Fees records");
        System.out.println("[3] Back");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                dm.deleteEnrollment();
                break;
            case 2:
                dm.deleteTuitionFees();
                break;
            case 3:
                mm.mainmenu();
                break;
            default:
                System.out.println("Invalid choice.");
                deleteMenu();
                break;
        }
    }
}
