/*
 * The ReadMenu class contains the GUI to present all read options.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.view;

import com.app.controller.AYTermController;
import com.app.controller.EnrollmentController;
import com.app.controller.FeesController;
import com.app.controller.ProgramController;
import com.app.controller.ScheduleController;
import com.app.controller.ScholarshipController;
import com.app.controller.SectionController;
import com.app.controller.StudentController;
import com.app.controller.SubjectController;
import com.app.controller.TuitionController;
import com.app.controller.TuitionFeesController;
import com.app.model.AYTerm;
import com.app.model.Enrollment;
import com.app.model.Fees;
import com.app.model.Program;
import com.app.model.Schedule;
import com.app.model.Scholarship;
import com.app.model.Section;
import com.app.model.Student;
import com.app.model.Subject;
import com.app.model.Tuition;
import com.app.model.TuitionFees;
import java.util.ArrayList;

public class ReadMenu {

    CRUDMenu cm = new CRUDMenu();

    public void readAYTerm() {
        try {
            // Retrieve AY term list from controller
            AYTermController ayc = new AYTermController();
            ArrayList<AYTerm> aytermList = ayc.readAYTerm();

            // Display table headers
            System.out.println("\nAY Term Records");
            System.out.println("=====================");

            // Display AY term information
            for (AYTerm ayterm : aytermList) {
                System.out.println(ayterm.getAYTerm());
                System.out.println("---------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying AY Term records: " + e.getMessage());
        }
        cm.readMenu();
    }

    public void readEnrollment() {
        try {
            // Retrieve enrollment list from controller
            EnrollmentController ec = new EnrollmentController();
            ArrayList<Enrollment> enrollmentList = ec.readEnrollment();

            // Display table headers
            System.out.println("\nEnrollmentID  StudentID         ScheduleID   AYTerm");
            System.out.println("==================================================================");

            // Display enrollment information
            for (Enrollment enrollment : enrollmentList) {
                System.out.printf("%-15d%-18s%-13d%-22s%n",
                        enrollment.getEnrollmentID(),
                        enrollment.getStudentID(),
                        enrollment.getScheduleID(),
                        enrollment.getAYTerm());
                System.out.println("------------------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying enrollment records: " + e.getMessage());
        }
        cm.readMenu();
    }

    public void readFees() {
        try {
            // Retrieve enrollment list from controller
            FeesController fc = new FeesController();
            ArrayList<Fees> feesList = fc.readFees();

            // Display table headers
            System.out.println("\nFee Name\t\t\tAmount");
            System.out.println("========================================");

            // Display fees information
            for (Fees fees : feesList) {
                System.out.printf("%-26s\t%.2f%n",
                        fees.getFeeName(),
                        fees.getAmount());
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Fees records: " + e.getMessage());
        }
        cm.readMenu();
    }

    public void readProgram() {
        try {
            // Retrieve enrollment list from controller
            ProgramController pc = new ProgramController();
            ArrayList<Program> programList = pc.readProgram();

            // Display table headers
            System.out.println("\nProgramCode\tProgramDescription\tMaxUnitsEnrolled");
            System.out.println("=========================================================");

            // Display program information
            for (Program program : programList) {
                System.out.printf("%-15s\t%-25s\t%.2f%n",
                        program.getProgramCode(),
                        program.getProgramDesc(),
                        program.getMaxUnitsEnrolled());
                System.out.println("---------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Program records: " + e.getMessage());
        }
        cm.readMenu();
    }

    public void readSchedule() {
        try {
            // Retrieve enrollment list from controller
            ScheduleController sc = new ScheduleController();
            ArrayList<Schedule> scheduleList = sc.readSchedule();

            // Display table headers
            System.out.println(
                    "\nScheduleID      SubjectCode        SectionCode         Schedule                     AYTerm");
            System.out.println("===========================================================");

            // Display program information
            for (Schedule schedule : scheduleList) {
                System.out.printf("%-15s %-15s %-15s %-30s %-10s%n",
                        schedule.getScheduleID(),
                        schedule.getSubjectCode(),
                        schedule.getSectionCode(),
                        schedule.getSchedule(),
                        schedule.getAYTerm());
                System.out.println("-----------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Schedule records: " + e.getMessage());
        }
        cm.readMenu();
    }

    public void readScholarship() {
        try {
            // Retrieve AY term list from controller
            ScholarshipController sc = new ScholarshipController();
            ArrayList<Scholarship> scholarshipList = sc.readScholarship();

            // Display table headers
            System.out.println("\nScholarship Records");
            System.out.println("=====================");

            // Display AY term information
            for (Scholarship scholarship : scholarshipList) {
                System.out.println(scholarship.getScholarship());
                System.out.println("---------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Scholarship records: " + e.getMessage());
        }
        cm.readMenu();

    }

    public void readSection() {
        try {
            // Retrieve AY term list from controller
            SectionController sc = new SectionController();
            ArrayList<Section> SectionList = sc.readsection();

            // Display table headers
            System.out.println("\nSection Records");
            System.out.println("=====================");

            // Display AY term information
            for (Section section : SectionList) {
                System.out.println(section.getSectionCode());
                System.out.println("---------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Section records: " + e.getMessage());
        }
        cm.readMenu();

    }

    public void readStudent() {
        try {
            // Retrieve student list from controller
            StudentController sc = new StudentController();
            ArrayList<Student> studentList = sc.readStudent();

            // Display table headers
            System.out.println(
                    "\nStudentID       StudentName           AYTerm                     Scholarship          ProgramCode    ContactNumber              Address                                               YearLevel         Section        Campus");
            System.out.println(
                    "===================================================================================================================================================================================================================================");

            // Display student information
            for (Student student : studentList) {
                System.out.printf("%-15s %-20s %-29s %-20s %-15s %-15s %-60s %-20s %-10s %-15s%n",
                        student.getStudentID(),
                        student.getStudentName(),
                        student.getAYTerm(),
                        student.getScholarship(),
                        student.getProgramCode(),
                        student.getContactNumber(),
                        student.getAddress(),
                        student.getYearLevel(),
                        student.getSection(),
                        student.getCampus());
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Student records: " + e.getMessage());
        }

        // Call readMenu() method if it exists
        cm.readMenu();
    }

    public void readSubject() {
        try {
            // Retrieve subject list from controller
            SubjectController sc = new SubjectController();
            ArrayList<Subject> subjectList = sc.readSubject();

            // Display table headers
            System.out.println("\n");
            System.out.println(
                    "Subject Code     Subject Title                                           Tuition Units  Credited Units");
            System.out.println(
                    "========================================================================================================");

            // Display subject information
            for (Subject subject : subjectList) {
                System.out.printf("%-15s %-60s %-15s %-15s%n",
                        subject.getSubjectCode(),
                        subject.getSubjectTitle(),
                        subject.getTuitionUnits(),
                        subject.getCreditedUnits());
                System.out.println(
                        "------------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying subject records: " + e.getMessage());
        }

        // Call readMenu() method if it exists
        cm.readMenu();
    }

    public void readTuition() {
        try {
            // Retrieve tuition list from controller
            TuitionController tc = new TuitionController();
            ArrayList<Tuition> tuitionList = tc.readTuition();

            // Display table headers
            System.out.println("\n");
            System.out.println(
                    "TuitionID     StudentID         AYTerm               TotalTuitionUnits  TotalCreditedUnits  TuitionAmount  TotalAssessment");
            System.out.println(
                    "=============================================================================================================");

            // Display tuition information
            for (Tuition tuition : tuitionList) {
                System.out.printf("%-15s %-15s %-25s %-20s %-20s %-15s %-15s%n",
                        tuition.getTuitionID(),
                        tuition.getStudentID(),
                        tuition.getAYTerm(),
                        tuition.getTotalTuitionUnits(),
                        tuition.getTotalCreditedUnits(),
                        tuition.getTuitionAmount(),
                        tuition.getTotalAssessment());
                System.out.println(
                        "----------------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying Tuition records: " + e.getMessage());
        }

        // Call readMenu() method if it exists
        cm.readMenu();
    }

    public void readTuitionFees() {
        try {
            // Retrieve student list from controller
            TuitionFeesController tc = new TuitionFeesController();
            ArrayList<TuitionFees> tuitionFeesList = tc.readtuitionFee();

            // Display table headers
            System.out.println("\n");
            System.out.println("TuitionFeesID    TuitionID    FeeName");
            System.out.println("======================================");

            // Display tuition fees information
            for (TuitionFees tuitionFees : tuitionFeesList) {
                System.out.printf("%-15s %-15s %-15s%n",
                        tuitionFees.getTuitionFeesID(),
                        tuitionFees.getTuitionID(),
                        tuitionFees.getFeeName());
                System.out.println("--------------------------------------------------");
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            System.err.println("Error displaying TuitionFees records: " + e.getMessage());
        }

        // Call readMenu() method if it exists
        cm.readMenu();
    }

}
