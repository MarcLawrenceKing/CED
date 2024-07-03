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
}
