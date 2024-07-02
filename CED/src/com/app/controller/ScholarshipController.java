/*
 * The ScholarshipController class holds Scholarship functionalities.
 * 
 * This class interconnects with the database thru SQL Queries defined in the QueryConstant class
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Scholarship;
import java.util.ArrayList;

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
