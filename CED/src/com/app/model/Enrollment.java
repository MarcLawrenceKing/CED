/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

/**
 *
 * @author marcl
 */
public class Enrollment {
    private int EnrollmentID;
    private int StudentID;
    private int ScheduleID;
    private String AYTerm;

    
    public Enrollment(){
        
    }

    public Enrollment(int EnrollmentID, int StudentID, int ScheduleID, String AYTerm) {
        this.EnrollmentID = EnrollmentID;
        this.StudentID = StudentID;
        this.ScheduleID = ScheduleID;
        this.AYTerm = AYTerm;

    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }


    public int getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(int ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    public String getAYTerm() {
        return AYTerm;
    }

    public void setAYTerm(String AYTerm) {
        this.AYTerm = AYTerm;
    }    
    
}
