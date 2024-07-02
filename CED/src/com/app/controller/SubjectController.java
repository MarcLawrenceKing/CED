/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.CED.DBConnection;
import com.app.model.Schedule;
import com.app.model.Subject;
import java.util.ArrayList;

/**
 *
 * @author marcl
 */
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
