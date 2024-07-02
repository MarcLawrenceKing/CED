/*
 * The DeleteMenu class contains the GUI to present all delete options.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.view;

import com.app.controller.EnrollmentController;
import com.app.controller.TuitionFeesController;
import com.app.model.Enrollment;
import com.app.model.TuitionFees;
import java.util.Scanner;

public class DeleteMenu {

    CRUDMenu cm = new CRUDMenu();

    public void deleteEnrollment() {
        try {
            EnrollmentController ec = new EnrollmentController();
            Enrollment enrollment = new Enrollment();
            Scanner sc = new Scanner(System.in);
            ReadMenu rm = new ReadMenu();

            System.out.println("\n**Delete Enrollment record**");
            System.out.print("Enter Enrollment ID you want to delete: ");
            enrollment.setEnrollmentID(sc.nextInt());

            System.out.print("Delete Enrollment record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                ec.deleteEnrollment(enrollment);
            } else {
                System.out.println("Enrollment was not deleted.");
            }

            System.out.print("\nDo you want to delete more Enrollment records? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                deleteEnrollment();
            } else {
                System.out.println("\n**Updated Enrollment records**");
                rm.readEnrollment();
                cm.deleteMenu();
            }

        } catch (Exception e) {
            System.out.println(e);
            cm.deleteMenu();
        }

    }

    public void deleteTuitionFees() {
        try {
            TuitionFeesController ec = new TuitionFeesController();
            TuitionFees tuitionfees = new TuitionFees();
            Scanner sc = new Scanner(System.in);
            ReadMenu rm = new ReadMenu();

            System.out.println("\n**Delete TuitionFees record**");
            System.out.print("Enter TuitionFee ID you want to delete: ");
            tuitionfees.setTuitionFeesID(sc.nextInt());

            System.out.print("Delete TuitionFee record? [Y/N]: ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                ec.deleteTuitionFees(tuitionfees);
            } else {
                System.out.println("TuitionFee was not deleted.");
            }

            System.out.print("\nDo you want to delete more TuitionFees records? [Y/N]: ");
            char add_more = sc.next().toLowerCase().charAt(0);

            if (add_more == 'y') {
                deleteTuitionFees();
            } else {
                System.out.println("\n**Updated TuitionFees records**");
                rm.readTuitionFees();
                cm.deleteMenu();
            }

        } catch (Exception e) {
            System.out.println(e);
            cm.deleteMenu();
        }

    }

}
