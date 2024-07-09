/*
 * The TuitionController class holds Tuition functionalities.
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
import com.app.model.Tuition;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TuitionController extends DBConnection {
    public void addTuition(Tuition tuition) {
        try {
            connect();

            prep = con.prepareStatement(ADD_TUITION);
            prep.setInt(1, tuition.getStudentID());
            prep.setString(2, tuition.getAYTerm());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nTuition record added successfully!");
            } else {
                System.out.println("\nFailed to add Tuition record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ArrayList<Tuition> readTuition() {//for console printing only
        ArrayList<Tuition> tuitionList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_TUITION);

            while (result.next()) {
                Tuition tuitionToList = new Tuition();
                tuitionToList.setTuitionID(result.getInt("TuitionID"));
                tuitionToList.setStudentID(result.getInt("StudentID"));
                tuitionToList.setAYTerm(result.getString("AYTerm"));
                tuitionToList.setTotalTuitionUnits(result.getFloat("TotalTuitionUnits"));
                tuitionToList.setTotalCreditedUnits(result.getFloat("TotalCreditedUnits"));
                tuitionToList.setTotalFees(result.getFloat("TotalFees"));
                tuitionToList.setTuitionAmount(result.getFloat("TuitionAmount"));
                tuitionToList.setTotalAssessment(result.getString("TotalAssessment"));

                tuitionList.add(tuitionToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return tuitionList;
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
    
    public void loadTuitionFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_TUITION);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"TuitionID", "StudentID","AYTerm","TotalTuitionUnits","TotalCreditedUnits","TuitionAmount","TotalFees","TotalAssessment"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getInt("TuitionID"));
                v.add(result.getInt("StudentID"));
                v.add(result.getString("AYTerm"));
                v.add(result.getFloat("TotalTuitionUnits"));
                v.add(result.getFloat("TotalCreditedUnits"));
                v.add(result.getFloat("TuitionAmount"));
                v.add(result.getFloat("TotalFees"));
                v.add(result.getString("TotalAssessment"));                

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
