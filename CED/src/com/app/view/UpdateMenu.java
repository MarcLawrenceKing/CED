/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import com.app.controller.ScheduleController;
import com.app.controller.StudentController;
import com.app.model.Schedule;
import com.app.model.Student;
import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class UpdateMenu {

    CRUDMenu cm = new CRUDMenu();

    public void updateSchedule() {
        ReadMenu rm = new ReadMenu();
        Schedule schedule = new Schedule();
        Scanner sc = new Scanner(System.in);
        ScheduleController scc = new ScheduleController();
        
        System.out.print("Enter Schedule ID you want to update: ");
        schedule.setScheduleID(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter new schedule: ");
        schedule.setSchedule(sc.nextLine());
        
        System.out.print("Update Schedule record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                scc.updateSchedule(schedule);
            } else {
                System.out.println("Schedule was not updated.");
            }

            System.out.print("\nDo you want to update more Schedule records? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                updateSchedule();
            } else {
                System.out.println("\n**Updated Schedule records**");
                rm.readSchedule();
                cm.updateMenu();
            }
    }

    public void updateStudent() {
        ReadMenu rm = new ReadMenu();
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        StudentController stc = new StudentController();
        
        System.out.print("Enter Student ID you want to update: ");
        student.setStudentID(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter new AYTerm: ");
        student.setAYTerm(sc.nextLine());
        System.out.print("Enter new Scholarship: ");
        student.setScholarship(sc.nextLine());
        System.out.print("Enter new ProgramCode: ");
        student.setProgramCode(sc.nextLine());
        System.out.print("Enter new StudentName: ");
        student.setStudentName(sc.nextLine());
        System.out.print("Enter new ContactNumber: ");
        student.setContactNumber(sc.nextLine());
        System.out.print("Enter new Address: ");
        student.setAddress(sc.nextLine());
        System.out.print("Enter new YearLevel: ");
        student.setYearLevel(sc.nextLine());
        System.out.print("Enter new Section: ");
        student.setSection(sc.nextLine());
        System.out.print("Enter new Campus: ");
        student.setCampus(sc.nextLine());
                
        System.out.print("Update Student record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                stc.updateStudent(student);
            } else {
                System.out.println("Student was not updated.");
            }

            System.out.print("\nDo you want to update more Student records? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                updateStudent();
            } else {
                System.out.println("\n**Updated Student records**");
                rm.readStudent();
                cm.updateMenu();
            }
    }

}
