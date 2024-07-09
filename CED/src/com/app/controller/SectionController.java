/*
 * The SectionController class holds Section functionalities.
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
import com.app.model.Section;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SectionController extends DBConnection {
    public void addSection(Section section) {
        try {
            connect();

            prep = con.prepareStatement(ADD_SECTION);
            prep.setString(1, section.getSectionCode());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nSection record added successfully!");
            } else {
                System.out.println("\nFailed to add Section record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Section> readsection() {//for console printing only
        ArrayList<Section> sectionList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SECTION);

            while (result.next()) {
                Section sectionToList = new Section();
                sectionToList.setSectionCode(result.getString("SectionCode"));

                sectionList.add(sectionToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return sectionList;
    }
    
    public void loadSectionFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SECTION);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"SectionCode"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getString("SectionCode"));               

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
