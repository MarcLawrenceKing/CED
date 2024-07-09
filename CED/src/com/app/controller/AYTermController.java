/*
 * The AYTermController class holds AYTerm functionalities.
 * 
 * This class interconnects with the database thru SQL Queries defined in the QueryConstant class
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.AYTerm;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AYTermController extends DBConnection {

    public void addAYTerm(AYTerm ayterm) {
        try {
            connect();

            prep = con.prepareStatement(ADD_AYTERM);
            prep.setString(1, ayterm.getAYTerm());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) { // exception handling
                System.out.println("\nAY Term record added successfully!");
            } else {
                System.out.println("\nFailed to add AY Term record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<AYTerm> readAYTerm() { //for console printing only
        ArrayList<AYTerm> aytermList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_AYTERM);

            while (result.next()) {
                AYTerm aytermToList = new AYTerm();
                aytermToList.setAYTerm(result.getString("AYTerm"));

                aytermList.add(aytermToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return aytermList;

    }

    public void loadAYTermFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_AYTERM);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"AY Term"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getString("AYTerm"));

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
