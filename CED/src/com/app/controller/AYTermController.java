package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.AYTerm;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class AYTermController extends DBConnection {

    public void addAYTerm(AYTerm ayterm) {
        try {
            connect();

            PreparedStatement statement = con.prepareStatement("INSERT INTO ayterm (AYTerm) VALUES (?)");
            statement.setString(1, ayterm.getAYTerm());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { //exception handling
                System.out.println("\nAY Term record added successfully!");
            } else {
                System.out.println("\nFailed to add AY Term record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<AYTerm> readAYTerm() {
        ArrayList<AYTerm> aytermList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery("SELECT * FROM ayterm ORDER BY ayterm");

            while (result.next()) {
                AYTerm aytermToList = new AYTerm();
                aytermToList.setAYTerm(result.getString("AYTerm"));

                aytermList.add(aytermToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return aytermList;

    }
    

}
