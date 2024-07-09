/*
 * The TuitionFeesController class holds TuitionFees functionalities.
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
import com.app.model.TuitionFees;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TuitionFeesController extends DBConnection {

    public void addTuitionFees(TuitionFees tuitionfees) {
        try {
            connect();

            prep = con.prepareStatement(ADD_TUITIONFEES);
            prep.setInt(1, tuitionfees.getTuitionID());
            prep.setString(2, tuitionfees.getFeeName());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nTuitionFee record added successfully!");
            } else {
                System.out.println("\nFailed to add TuitionFee record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<TuitionFees> readtuitionFee() {//for console printing only
        ArrayList<TuitionFees> tuitionFeeList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_TUITIONFEES);

            while (result.next()) {
                TuitionFees tuitionFeeToList = new TuitionFees();
                tuitionFeeToList.setTuitionFeesID(result.getInt("TuitionFeesID"));
                tuitionFeeToList.setTuitionID(result.getInt("TuitionID"));
                tuitionFeeToList.setFeeName(result.getString("FeeName"));

                tuitionFeeList.add(tuitionFeeToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return tuitionFeeList;
    }

    public void deleteTuitionFees(TuitionFees tuitionfees) {

        try {
            connect();
            prep = con.prepareStatement(DELETE_TUITIONFEES);
            prep.setInt(1, tuitionfees.getTuitionFeesID());

            prep.executeUpdate();
            System.out.println("TuitionFees " + tuitionfees.getTuitionFeesID() + " deleted successfully");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void populateTuitionComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_TUITION);

            while (result.next()) {
                String item = result.getString("TuitionID");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void populateFeeComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_FEES);

            while (result.next()) {
                String item = result.getString("FeeName");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void populateTuitionFeeComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_TUITIONFEES);

            while (result.next()) {
                String item = result.getString("TuitionFeesID");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadTuitionFeesFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_TUITIONFEES);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();

            dt.setColumnIdentifiers(new Object[]{"TuitionFeesID", "TuitionID", "FeeName"});
            dt.setRowCount(0);

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getInt("TuitionFeesID"));
                v.add(result.getInt("TuitionID"));
                v.add(result.getString("FeeName"));
                
                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
