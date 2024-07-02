/*
 * The SubjectController class holds Subject functionalities.
 * 
 * This class interconnects with the database thru SQL Queries defined in the QueryConstant class
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Subject;
import java.util.ArrayList;

public class SubjectController extends DBConnection {
    public ArrayList<Subject> readSubject() {
        ArrayList<Subject> subjectList = new ArrayList<>();

        try {
            connect();
            state = con.createStatement();
            result = state.executeQuery(READ_SUBJECT);

            while (result.next()) {
                Subject subjectToList = new Subject();
                subjectToList.setSubjectCode(result.getString("SubjectCode"));
                subjectToList.setSubjectTitle(result.getString("SubjectTitle"));
                subjectToList.setTuitionUnits(result.getFloat("TuitionUnits"));
                subjectToList.setCreditedUnits(result.getFloat("CreditedUnits"));

                subjectList.add(subjectToList);
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return subjectList;
    }
}
