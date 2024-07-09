/*
 * The StudentController class holds Student functionalities.
 * 
 * This class interconnects with the database thru SQL Queries defined in the QueryConstant class
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.controller;

import com.app.CED.DBConnection;
import static com.app.CED.DBConnection.connect;
import static com.app.model.QueryConstant.READ_PROGRAM;
import com.app.model.Student;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentController extends DBConnection {

    public void addStudent(Student student) {
        try {
            connect();

            prep = con.prepareStatement(ADD_STUDENT);
            prep.setString(1, student.getStudentName());
            prep.setString(2, student.getAYTerm());
            prep.setString(3, student.getScholarship());
            prep.setString(4, student.getProgramCode());
            prep.setString(5, student.getContactNumber());
            prep.setString(6, student.getAddress());
            prep.setString(7, student.getYearLevel());
            prep.setString(8, student.getSection());
            prep.setString(9, student.getCampus());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nStudent record added successfully!");
            } else {
                System.out.println("\nFailed to add student record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Student> readStudent() {//for console printing only
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

    public void populateAYTermComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_AYTERM);

            while (result.next()) {
                String item = result.getString("AYTerm");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateScholarshipComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SCHOLARSHIP);

            while (result.next()) {
                String item = result.getString("Scholarship");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateProgramComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_PROGRAM);

            while (result.next()) {
                String item = result.getString("ProgramCode");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateStudentComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_STUDENT);

            while (result.next()) {
                String item = result.getString("StudentID");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadStudentFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_STUDENT);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();

            dt.setColumnIdentifiers(new Object[]{"StudentID", "AYTerm", "Scholarship", "StudentName", "ContactNumber", "Address", "YearLevel", "Section", "Campus"});
            dt.setRowCount(0);

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getInt("StudentID"));
                v.add(result.getString("AYTerm"));
                v.add(result.getString("Scholarship"));
                v.add(result.getString("ProgramCode"));
                v.add(result.getString("StudentName"));
                v.add(result.getString("ContactNumber"));
                v.add(result.getString("Address"));
                v.add(result.getString("YearLevel"));
                v.add(result.getString("Section"));
                v.add(result.getString("Campus"));

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
