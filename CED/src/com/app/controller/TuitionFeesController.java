/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.TuitionFees;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
public class TuitionFeesController extends DBConnection { // dito natapos
    public ArrayList<TuitionFees> readtuitionFee() {
        ArrayList<TuitionFees> tuitionFeeList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery("SELECT * FROM tuitionfees ORDER BY TuitionFeesID");

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
            prep = con.prepareStatement("DELETE FROM tuitionfees WHERE TuitionFeesID = ?");
            prep.setInt(1, tuitionfees.getTuitionFeesID());

            prep.executeUpdate();
            System.out.println("TuitionFees " + tuitionfees.getTuitionFeesID() + " deleted successfully");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
