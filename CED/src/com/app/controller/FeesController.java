/*
 * The FeesController class holds Fees functionalities.
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
import com.app.model.Fees;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FeesController extends DBConnection {

    public ArrayList<Fees> readFees() { //console only
        ArrayList<Fees> feestList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_FEES);

            while (result.next()) {
                Fees feesToList = new Fees();
                feesToList.setFeeName(result.getString("FeeName"));
                feesToList.setAmount(result.getFloat("Amount"));

                feestList.add(feesToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return feestList;
    }
    
        public void loadFeesFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_FEES);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"FeeName", "Amount"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getString("FeeName"));
                v.add(result.getFloat("Amount"));

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
