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
public class Subject {
    private String SubjectCode;
    private String SubjectTitle;
    private float TuitionUnits;
    private float CreditedUnits;
    
    public Subject(){
        
    }

    public Subject(String SubjectCode, String SubjectTitle, float TuitionUnits, float CreditedUnits) {
        this.SubjectCode = SubjectCode;
        this.SubjectTitle = SubjectTitle;
        this.TuitionUnits = TuitionUnits;
        this.CreditedUnits = CreditedUnits;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String SubjectCode) {
        this.SubjectCode = SubjectCode;
    }

    public String getSubjectTitle() {
        return SubjectTitle;
    }

    public void setSubjectTitle(String SubjectTitle) {
        this.SubjectTitle = SubjectTitle;
    }

    public float getTuitionUnits() {
        return TuitionUnits;
    }

    public void setTuitionUnits(float TuitionUnits) {
        this.TuitionUnits = TuitionUnits;
    }

    public float getCreditedUnits() {
        return CreditedUnits;
    }

    public void setCreditedUnits(float CreditedUnits) {
        this.CreditedUnits = CreditedUnits;
    }
    
    
    
}
