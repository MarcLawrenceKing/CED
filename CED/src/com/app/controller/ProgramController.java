/*
 * The ProgramController class holds Program functionalities.
 * 
 * This class interconnects with the database thru SQL Queries defined in the QueryConstant class
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Program;
import java.util.ArrayList;

public class ProgramController extends DBConnection {

    public ArrayList<Program> readProgram() {
        ArrayList<Program> programList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_PROGRAM);

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
