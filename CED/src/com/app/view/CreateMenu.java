/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import com.app.controller.AYTermController;
import com.app.controller.EnrollmentController;
import com.app.controller.ScheduleController;
import com.app.controller.SectionController;
import com.app.controller.StudentController;
import com.app.model.AYTerm;
import com.app.model.Enrollment;
import com.app.model.Schedule;
import com.app.model.Section;
import com.app.model.Student;
import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class CreateMenu {

    public void createAYTerm() {
        ReadMenu rm = new ReadMenu();
        CRUDMenu cm = new CRUDMenu();
        AYTerm ayterm = new AYTerm();
        AYTermController ayc = new AYTermController();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n** Create AY Term record **");
            System.out.print("Enter AY Term: ");
            ayterm.setAYTerm(sc.nextLine());

            System.out.print("Create a new AY Term record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                ayc.addAYTerm(ayterm);
            } else {
                System.out.println("Record was not created.");
            }
            System.out.print("\nDo you want to add more AY Term record? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                createAYTerm();
            } else {
                System.out.println("\n**Updated AYTerm records**");
                rm.readAYTerm();
                cm.createMenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            cm.createMenu();
        }

    }

    public void createEnrollment() {
        ReadMenu rm = new ReadMenu();
        CRUDMenu cm = new CRUDMenu();
        Enrollment enrollment = new Enrollment();
        EnrollmentController ec = new EnrollmentController();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n** Create Enrollment record **");
            System.out.print("Enter Student ID: ");
            enrollment.setStudentID(sc.nextInt());
            System.out.print("Enter Schedule ID: ");
            enrollment.setScheduleID(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter AYTerm: ");
            enrollment.setAYTerm(sc.nextLine());

            System.out.print("Create a new Enrollment record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                ec.addEnrollment(enrollment);
            } else {
                System.out.println("Record was not created.");
            }
            System.out.print("\nDo you want to add more Enrollment record? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                createEnrollment();
            } else {
                System.out.println("\n**Updated Enrollment records**");
                rm.readEnrollment();
                cm.createMenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            cm.createMenu();
        }
    }

    public void createSchedule() {
        ReadMenu rm = new ReadMenu();
        CRUDMenu cm = new CRUDMenu();
        Schedule schedule = new Schedule();
        ScheduleController ec = new ScheduleController();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n** Create Schedule record **");
            System.out.print("Enter Subject Code: ");
            schedule.setSubjectCode(sc.nextLine());
            System.out.print("Enter Section Code: ");
            schedule.setSectionCode(sc.nextLine());
            System.out.print("Enter AY Term: ");
            schedule.setAYTerm(sc.nextLine());
            System.out.print("Enter Schedule: ");
            schedule.setSchedule(sc.nextLine());

            System.out.print("Create a new Schedule record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                ec.addSchedule(schedule);
            } else {
                System.out.println("Record was not created.");
            }
            System.out.print("\nDo you want to add more Schedule record? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                createSchedule();
            } else {
                System.out.println("\n**Updated Schedule records**");
                rm.readSchedule();
                cm.createMenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            cm.createMenu();
        }
    }

    public void createSection() {
        ReadMenu rm = new ReadMenu();
        CRUDMenu cm = new CRUDMenu();
        Section section = new Section();
        SectionController ec = new SectionController();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n** Create Section record **");
            System.out.print("Enter Section Code: ");
            section.setSectionCode(sc.nextLine());

            System.out.print("Create a new Section record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                ec.addSection(section);
            } else {
                System.out.println("Record was not created.");
            }
            System.out.print("\nDo you want to add more Section record? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                createSection();
            } else {
                System.out.println("\n**Updated Section records**");
                rm.readSection();
                cm.createMenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            cm.createMenu();
        }
    }

    public void createStudent() {
        ReadMenu rm = new ReadMenu();
        CRUDMenu cm = new CRUDMenu();
        Student student = new Student();
        StudentController stc = new StudentController();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\n** Create student record **");
            System.out.print("Enter Student Name: ");
            student.setStudentName(sc.nextLine());
            System.out.print("Enter AY Term: ");
            student.setAYTerm(sc.nextLine());
            System.out.print("Enter Scholarship: ");
            student.setScholarship(sc.nextLine());
            System.out.print("Enter Program Code: ");
            student.setProgramCode(sc.nextLine());
            System.out.print("Enter Contact Number: ");
            student.setContactNumber(sc.nextLine());
            System.out.print("Enter Address: ");
            student.setAddress(sc.nextLine());
            System.out.print("Enter Year Level: ");
            student.setYearLevel(sc.nextLine());
            System.out.print("Enter Section: ");
            student.setSection(sc.nextLine());
            System.out.print("Enter Campus: ");
            student.setCampus(sc.nextLine());

            System.out.print("Create a new student record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                stc.addStudent(student);
            } else {
                System.out.println("Record was not created.");
            }
            System.out.print("\nDo you want to add more student record? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                createStudent();
            } else {
                System.out.println("\n**Updated Student records**");
                rm.readStudent();
                cm.createMenu();
            }
        } catch (Exception e) {
            System.out.println(e);
            cm.createMenu();
        }
    }

}
