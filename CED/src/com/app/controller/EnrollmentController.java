package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Enrollment;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class EnrollmentController extends DBConnection {

    public void addEnrollment(Enrollment enrollment) {
        try {
            connect();

            PreparedStatement statement = con
                    .prepareStatement(ADD_ENROLLMENT);
            statement.setInt(1, enrollment.getStudentID());
            statement.setInt(2, enrollment.getScheduleID());
            statement.setString(3, enrollment.getAYTerm());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { // exception handling
                System.out.println("\nEnrollment record added successfully!");
            } else {
                System.out.println("\nFailed to add Enrollment record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Enrollment> readEnrollment() {
        ArrayList<Enrollment> enrollmentList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_ENROLLMENT);

            while (result.next()) {
                Enrollment enrollmentToList = new Enrollment();
                enrollmentToList.setEnrollmentID(result.getInt("EnrollmentID"));
                enrollmentToList.setStudentID(result.getInt("StudentID"));
                enrollmentToList.setScheduleID(result.getInt("ScheduleID"));
                enrollmentToList.setAYTerm(result.getString("AYTerm"));

                enrollmentList.add(enrollmentToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return enrollmentList;
    }

    public void deleteEnrollment(Enrollment enrollment) {

        try {
            connect();
            prep = con.prepareStatement(DELETE_ENROLLMENT);
            prep.setInt(1, enrollment.getEnrollmentID());

            prep.executeUpdate();
            System.out.println("Enrollment " + enrollment.getEnrollmentID() + " deleted successfully");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
