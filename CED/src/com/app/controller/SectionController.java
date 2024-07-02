/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Section;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
public class SectionController extends DBConnection {
    public void addSection(Section section) {
        try {
            connect();

            PreparedStatement statement = con.prepareStatement("INSERT INTO section (SectionCode) VALUES (?)");
            statement.setString(1, section.getSectionCode());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { // exception handling
                System.out.println("\nSection record added successfully!");
            } else {
                System.out.println("\nFailed to add Section record.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Section> readsection() {
        ArrayList<Section> sectionList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery("SELECT * FROM section ORDER BY SectionCode");

            while (result.next()) {
                Section sectionToList = new Section();
                sectionToList.setSectionCode(result.getString("SectionCode"));
                

                sectionList.add(sectionToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return sectionList;
    }
}
