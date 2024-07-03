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
import com.app.model.TuitionFees;
import java.util.ArrayList;

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
                System.out.println("\nFailed to add nTuitionFee record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ArrayList<TuitionFees> readtuitionFee() {
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
}
