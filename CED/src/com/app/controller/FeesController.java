/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Fees;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
public class FeesController extends DBConnection {

    public ArrayList<Fees> readFees() {
        ArrayList<Fees> feestList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery("SELECT * FROM fees ORDER BY FeeName");

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
}
