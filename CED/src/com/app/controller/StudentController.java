/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Student;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
public class StudentController extends DBConnection {

    public void addStudent(Student student) {
        try {
            connect();

            PreparedStatement statement = con.prepareStatement(ADD_STUDENT);
            statement.setString(1, student.getStudentName());
            statement.setString(2, student.getAYTerm());
            statement.setString(3, student.getScholarship());
            statement.setString(4, student.getProgramCode());
            statement.setString(5, student.getContactNumber());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getYearLevel());
            statement.setString(8, student.getSection());
            statement.setString(9, student.getCampus());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { // exception handling
                System.out.println("\nStudent record added successfully!");
            } else {
                System.out.println("\nFailed to add student record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Student> readStudent() {
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_STUDENT);

            while (result.next()) {
                Student studentToList = new Student();
                studentToList.setStudentID(result.getInt("StudentID"));
                studentToList.setStudentName(result.getString("StudentName"));
                studentToList.setAYTerm(result.getString("AYTerm"));
                studentToList.setScholarship(result.getString("Scholarship"));
                studentToList.setProgramCode(result.getString("ProgramCode"));
                studentToList.setContactNumber(result.getString("ContactNumber"));
                studentToList.setAddress(result.getString("Address"));
                studentToList.setYearLevel(result.getString("YearLevel"));
                studentToList.setSection(result.getString("Section"));
                studentToList.setCampus(result.getString("Campus"));

                studentList.add(studentToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return studentList;
    }

    public void updateStudent(Student student) {

        try {
            connect();
            prep = con.prepareStatement(UPDATE_STUDENT);
            prep.setString(1, student.getAYTerm());
            prep.setString(2, student.getScholarship());
            prep.setString(3, student.getProgramCode());
            prep.setString(4, student.getStudentName());
            prep.setString(5, student.getContactNumber());
            prep.setString(6, student.getAddress());
            prep.setString(7, student.getYearLevel());
            prep.setString(8, student.getSection());
            prep.setString(9, student.getCampus());
            prep.setInt(10, student.getStudentID());
            prep.executeUpdate();
            System.out.println("Student " + student.getStudentID() + " updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
