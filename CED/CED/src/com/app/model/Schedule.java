/*
 * The Schedule class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public class Schedule {
    private int ScheduleID;
    private String SubjectCode;
    private String SectionCode;
    private String AYTerm;
    private String Schedule;

    public Schedule() {

    }

    public Schedule(int ScheduleID, String SubjectCode, String SectionCode, String AYTerm, String Schedule) {
        this.ScheduleID = ScheduleID;
        this.SubjectCode = SubjectCode;
        this.SectionCode = SectionCode;
        this.AYTerm = AYTerm;
        this.Schedule = Schedule;
    }

    public int getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(int ScheduleID) {
        this.ScheduleID = ScheduleID;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String SubjectCode) {
        this.SubjectCode = SubjectCode;
    }

    public String getSectionCode() {
        return SectionCode;
    }

    public void setSectionCode(String SectionCode) {
        this.SectionCode = SectionCode;
    }

    public String getAYTerm() {
        return AYTerm;
    }

    public void setAYTerm(String AYTerm) {
        this.AYTerm = AYTerm;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String Schedule) {
        this.Schedule = Schedule;
    }

}
