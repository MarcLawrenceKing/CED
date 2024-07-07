/*
 * The QueryConstant class contains the variables used in DBConnection class, it also contains all the queries being used in all controllers.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public interface QueryConstant {

        final static String URL = "jdbc:mysql://localhost:3306/cor_db";
        final static String USERNAME = "root";
        final static String PASSWORD = "";
        final static String DRIVER = "com.mysql.jdbc.Driver";

        // AYTermController
        String ADD_AYTERM = "INSERT INTO ayterm (AYTerm) VALUES (?)";
        String READ_AYTERM = "SELECT * FROM ayterm ORDER BY ayterm";

        // CORController
        String STUDENT_DETAILS = "SELECT s.StudentID, s.StudentName, s.AYTerm, p.ProgramDesc, p.ProgramCode, "
                        + "s.Campus, s.YearLevel, s.Section, s.Address, s.ContactNumber, s.Scholarship "
                        + "FROM Student s "
                        + "JOIN Program p ON s.ProgramCode = p.ProgramCode "
                        + "WHERE s.StudentID = ?";
        String SUBJECT_DETAILS = "SELECT sc.SubjectCode, su.SubjectTitle, sc.SectionCode, su.TuitionUnits, su.CreditedUnits, sc.Schedule "
                        + "FROM Schedule sc "
                        + "JOIN Subject su ON sc.SubjectCode = su.SubjectCode "
                        + "JOIN Enrollment en ON sc.ScheduleID = en.ScheduleID "
                        + "WHERE en.StudentID = ? AND sc.AYTerm = ?"
                        + "ORDER BY sc.SubjectCode";
        String RESET_TOTALS = "UPDATE Tuition "
                        + "SET TotalTuitionUnits = 0, TotalCreditedUnits = 0, TuitionAmount = 0, TotalFees = 0, TotalAssessment = 0 "
                        + "WHERE StudentID = ? AND AYTerm = ?";
        String FEES_DETAILS = "SELECT f.FeeName, f.Amount "
                        + "FROM TuitionFees tf "
                        + "JOIN Fees f ON tf.FeeName = f.FeeName "
                        + "JOIN Tuition t ON tf.TuitionID = t.TuitionID "
                        + "WHERE t.StudentID = ? AND t.AYTerm = ?"
                        + "ORDER BY f.FeeName";
        String TUITION_DETAILS = "SELECT p.MaxUnitsEnrolled, SUM(su.TuitionUnits) AS TotalTuitionUnits, SUM(su.CreditedUnits) AS TotalCreditedUnits, t.TotalAssessment "
                        + "FROM Tuition t "
                        + "JOIN Enrollment en ON t.StudentID = en.StudentID AND t.AYTerm = en.AYTerm "
                        + "JOIN Schedule sc ON en.ScheduleID = sc.ScheduleID "
                        + "JOIN Subject su ON sc.SubjectCode = su.SubjectCode "
                        + "JOIN Student st ON t.StudentID = st.StudentID "
                        + "JOIN Program p ON st.ProgramCode = p.ProgramCode "
                        + "WHERE t.StudentID = ? AND t.AYTerm = ? "
                        + "GROUP BY p.MaxUnitsEnrolled";
        String UPDATE_TOTALS = "UPDATE Tuition "
                        + "SET TotalTuitionUnits = ?, TotalCreditedUnits = ?, TuitionAmount = ?, TotalFees = ?, TotalAssessment = ?"
                        + "WHERE StudentID = ? AND AYTerm = ?";

        // EnrollmentController
        String ADD_ENROLLMENT = "INSERT INTO enrollment (StudentID, ScheduleID, AYTerm) VALUES (?, ?, ?)";
        String READ_ENROLLMENT = "SELECT * FROM enrollment ORDER BY EnrollmentID";
        String DELETE_ENROLLMENT = "DELETE FROM Enrollment WHERE EnrollmentID = ?";

        // FeesController
        String READ_FEES = "SELECT * FROM fees ORDER BY FeeName";

        // ProgramController
        String READ_PROGRAM = "SELECT * FROM program ORDER BY ProgramCode";

        // ScheduleController
        String ADD_SCHEDULE = "INSERT INTO schedule (SubjectCode, SectionCode, AYTerm, Schedule) VALUES (?, ?, ?, ?)";
        String READ_SCHEDULE = "SELECT * FROM schedule ORDER BY ScheduleID";
        String UPDATE_SCHEDULE = "UPDATE schedule SET Schedule = ? WHERE ScheduleID = ?";

        // ScholarshipController
        String READ_SCHOLARSHIP = "SELECT * FROM scholarship ORDER BY Scholarship";

        // SectionController
        String ADD_SECTION = "INSERT INTO section (SectionCode) VALUES (?)";
        String READ_SECTION = "SELECT * FROM section ORDER BY SectionCode";

        // StudentController
        String ADD_STUDENT = "INSERT INTO student (StudentName, AYTerm, Scholarship, ProgramCode, ContactNumber, Address, YearLevel, Section, Campus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String READ_STUDENT = "SELECT * FROM student ORDER BY StudentID";
        String UPDATE_STUDENT = "UPDATE student SET AYTerm = ?, Scholarship = ?, ProgramCode = ?, StudentName = ?, ContactNumber = ?, Address = ?, YearLevel = ?, Section = ?, Campus = ? WHERE StudentID = ?";

        // SubjectController
        String READ_SUBJECT = "SELECT * FROM subject ORDER BY SubjectCode";

        // TuitionController
        String ADD_TUITION = "INSERT INTO tuition (StudentID, AYTerm) VALUES (?, ?)";
        String READ_TUITION = "SELECT * FROM tuition ORDER BY TuitionID";

        // TuitionFeesController
        String ADD_TUITIONFEES = "INSERT INTO tuitionfees (TuitionID, FeeName) VALUES (?, ?)";
        String READ_TUITIONFEES = "SELECT * FROM tuitionfees ORDER BY TuitionFeesID";
        String DELETE_TUITIONFEES = "DELETE FROM tuitionfees WHERE TuitionFeesID = ?";
}
