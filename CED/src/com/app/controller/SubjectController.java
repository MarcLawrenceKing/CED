/*
 * The SubjectController class holds Subject functionalities.
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
import com.app.model.Subject;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SubjectController extends DBConnection {
    public ArrayList<Subject> readSubject() {//for console printing only
        ArrayList<Subject> subjectList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SUBJECT);

            while (result.next()) {
                Subject subjectToList = new Subject();
                subjectToList.setSubjectCode(result.getString("SubjectCode"));
                subjectToList.setSubjectTitle(result.getString("SubjectTitle"));
                subjectToList.setTuitionUnits(result.getFloat("TuitionUnits"));
                subjectToList.setCreditedUnits(result.getFloat("CreditedUnits"));

                subjectList.add(subjectToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return subjectList;
    }
    public void loadSubjectFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SUBJECT);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"SubjectCode", "SubjectTitle","TuitionUnits","CreditedUnits"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getString("SubjectCode"));
                v.add(result.getString("SubjectTitle"));
                v.add(result.getFloat("TuitionUnits"));
                v.add(result.getFloat("CreditedUnits"));

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
