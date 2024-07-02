/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Scholarship;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
public class ScholarshipController extends DBConnection {
    public ArrayList<Scholarship> readScholarship() {
        ArrayList<Scholarship> scholarshipList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SCHOLARSHIP);

            while (result.next()) {
                Scholarship scholarshipToList = new Scholarship();
                scholarshipToList.setScholarship(result.getString("Scholarship"));

                scholarshipList.add(scholarshipToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return scholarshipList;
    }
}
