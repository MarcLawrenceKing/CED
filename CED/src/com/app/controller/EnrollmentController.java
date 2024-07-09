/*
 * The EnrollmentController class holds Enrollment functionalities.
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
import com.app.model.Enrollment;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EnrollmentController extends DBConnection {

    public void addEnrollment(Enrollment enrollment) {
        try {
            connect();

            prep = con.prepareStatement(ADD_ENROLLMENT);
            prep.setInt(1, enrollment.getStudentID());
            prep.setInt(2, enrollment.getScheduleID());
            prep.setString(3, enrollment.getAYTerm());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nEnrollment record added successfully!");
            } else {
                System.out.println("\nFailed to add Enrollment record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Enrollment> readEnrollment() { //console only
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

    public void populateStudentIDComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_STUDENT);

            while (result.next()) {
                int itemInt = result.getInt("StudentID");
                String item = Integer.toString(itemInt);
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void populateScheduleIDComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SCHEDULE);

            while (result.next()) {
                int itemInt = result.getInt("ScheduleID");
                String item = Integer.toString(itemInt);
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    
    public void populateEnrollmentComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_ENROLLMENT);

            while (result.next()) {
                String item = result.getString("EnrollmentID");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void loadEnrollmentFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_ENROLLMENT);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"EnrollmentID", "StudentID", "ScheduleID", "AYTerm"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getInt("EnrollmentID"));
                v.add(result.getString("StudentID"));
                v.add(result.getString("ScheduleID"));
                v.add(result.getString("AYTerm"));

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
