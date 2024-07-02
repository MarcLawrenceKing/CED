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
import com.app.model.Tuition;
import java.util.ArrayList;

public class TuitionController extends DBConnection {
    public ArrayList<Tuition> readTuition() {
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
                tuitionToList.setTotalTuitionUnits(result.getInt("TotalTuitionUnits"));
                tuitionToList.setTotalCreditedUnits(result.getInt("TotalCreditedUnits"));
                tuitionToList.setTuitionAmount(result.getInt("TuitionAmount"));
                tuitionToList.setTotalAssessment(result.getString("TotalAssessment"));

                tuitionList.add(tuitionToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return tuitionList;
    }
}
