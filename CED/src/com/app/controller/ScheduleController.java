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
import com.app.model.Schedule;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ScheduleController extends DBConnection {

    public void addSchedule(Schedule schedule) {
        try {
            connect();

            PreparedStatement statement = con.prepareStatement(ADD_SCHEDULE);
            statement.setString(1, schedule.getSubjectCode());
            statement.setString(2, schedule.getSectionCode());
            statement.setString(3, schedule.getAYTerm());
            statement.setString(4, schedule.getSchedule());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nSchedule record added successfully!");
            } else {
                System.out.println("\nFailed to add Schedule record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Schedule> readSchedule() {
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
}
