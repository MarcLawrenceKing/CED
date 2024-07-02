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
public class Student {

    private int StudentID;
    private String StudentName;
    private String AYTerm;
    private String Scholarship;
    private String ProgramCode;
    private String ContactNumber;
    private String Address;
    private String YearLevel;
    private String Section;
    private String Campus;

    public Student() {

    }

    public Student(int StudentID, String StudentName, String AYTerm, String Scholarship, String ProgramCode, String ContactNumber, String Address, String YearLevel, String Section, String Campus) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.AYTerm = AYTerm;
        this.Scholarship = Scholarship;
        this.ProgramCode = ProgramCode;
        this.ContactNumber = ContactNumber;
        this.Address = Address;
        this.YearLevel = YearLevel;
        this.Section = Section;
        this.Campus = Campus;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getAYTerm() {
        return AYTerm;
    }

    public void setAYTerm(String AYTerm) {
        this.AYTerm = AYTerm;
    }

    public String getScholarship() {
        return Scholarship;
    }

    public void setScholarship(String Scholarship) {
        this.Scholarship = Scholarship;
    }

    public String getProgramCode() {
        return ProgramCode;
    }

    public void setProgramCode(String ProgramCode) {
        this.ProgramCode = ProgramCode;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getYearLevel() {
        return YearLevel;
    }

    public void setYearLevel(String YearLevel) {
        this.YearLevel = YearLevel;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String Section) {
        this.Section = Section;
    }

    public String getCampus() {
        return Campus;
    }

    public void setCampus(String Campus) {
        this.Campus = Campus;
    }

}
