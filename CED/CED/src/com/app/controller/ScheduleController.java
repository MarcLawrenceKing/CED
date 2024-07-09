/*
 * The ScheduleController class holds Schedule functionalities.
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
import com.app.model.Schedule;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScheduleController extends DBConnection {

    public void addSchedule(Schedule schedule) {
        try {
            connect();

            prep = con.prepareStatement(ADD_SCHEDULE);
            prep.setString(1, schedule.getSubjectCode());
            prep.setString(2, schedule.getSectionCode());
            prep.setString(3, schedule.getAYTerm());
            prep.setString(4, schedule.getSchedule());

            int rowsInserted = prep.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nSchedule record added successfully!");
            } else {
                System.out.println("\nFailed to add Schedule record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Schedule> readSchedule() {//for console printing only
        ArrayList<Schedule> scheduleList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SCHEDULE);

            while (result.next()) {
                Schedule scheduleToList = new Schedule();
                scheduleToList.setScheduleID(result.getInt("ScheduleID"));
                scheduleToList.setSubjectCode(result.getString("SubjectCode"));
                scheduleToList.setSectionCode(result.getString("SectionCode"));
                scheduleToList.setAYTerm(result.getString("AYTerm"));
                scheduleToList.setSchedule(result.getString("Schedule"));

                scheduleList.add(scheduleToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return scheduleList;
    }

    public void updateSchedule(Schedule schedule) {

        try {
            connect();
            prep = con.prepareStatement(UPDATE_SCHEDULE);
            prep.setString(1, schedule.getSchedule());
            prep.setInt(2, schedule.getScheduleID());
            prep.executeUpdate();
            System.out.println("Schedule " + schedule.getScheduleID() + " updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void populateSubjectCodeComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SUBJECT);

            while (result.next()) {
                String item = result.getString("SubjectCode");
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
    
    public void populateSectionCodeComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SECTION);

            while (result.next()) {
                String item = result.getString("SectionCode");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void populateScheduleComboBox(JComboBox<String> comboBox) {
        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SCHEDULE);

            while (result.next()) {
                String item = result.getString("ScheduleID");
                comboBox.addItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void loadScheduleFromDatabase(JTable jtable) {

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SCHEDULE);

            DefaultTableModel dt = (DefaultTableModel) jtable.getModel();
            
            dt.setColumnIdentifiers(new Object[]{"ScheduleID", "SubjectCode","SectionCode","Schedule","AYTerm"});
            dt.setRowCount(0);
            

            while (result.next()) {
                Vector v = new Vector();

                v.add(result.getInt("ScheduleID"));
                v.add(result.getString("SubjectCode"));
                v.add(result.getString("SectionCode"));
                v.add(result.getString("Schedule"));
                v.add(result.getString("AYTerm"));                

                dt.addRow(v);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
