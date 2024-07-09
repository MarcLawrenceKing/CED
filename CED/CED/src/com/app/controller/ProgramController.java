/*
 * The ProgramController class holds Program functionalities.
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
import com.app.model.Program;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProgramController extends DBConnection {

    public ArrayList<Program> readProgram() { //console only
        ArrayList<Program> programList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_PROGRAM);

            while (result.next()) {
                Program programToList = new Program();
                programToList.setProgramCode(result.getString("ProgramCode"));
                programToList.setProgramDesc(result.getString("ProgramDesc"));
                programToList.setMaxUnitsEnrolled(result.getFloat("MaxUnitsEnrolled"));

                programList.add(programToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return programList;
    }
    
    public void loadFeesFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_PROGRAM);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"ProgramCode", "ProgramDesc","MaxUnitsEnrolled"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getString("ProgramCode"));
                v.add(result.getString("ProgramDesc"));
                v.add(result.getFloat("MaxUnitsEnrolled"));

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
