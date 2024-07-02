/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Fees;
import com.app.model.Program;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
public class ProgramController extends DBConnection {

    public ArrayList<Program> readProgram() {
        ArrayList<Program> programList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery("SELECT * FROM program ORDER BY ProgramCode");

            while (result.next()) {
                Program programToList = new Program();
                programToList.setProgramCode(result.getString("ProgramCode"));
                programToList.setProgramDesc(result.getString("ProgramDesc"));
                programToList.setMaxUnitsEnrolled(result.getFloat("MaxUnitsEnrolled"));

                programList.add(programToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return programList;
    }
}
