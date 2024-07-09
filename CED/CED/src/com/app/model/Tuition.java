/*
 * The Tuition class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public class Tuition {
    private int TuitionID;
    private int StudentID;
    private String AYTerm;
    private float TotalTuitionUnits;
    private float TotalCreditedUnits;
    private float TotalFees;
    private float TuitionAmount;
    private String TotalAssessment;

    public Tuition() {

    }

    public Tuition(int TuitionID, int StudentID, String AYTerm, float TotalTuitionUnits, float TotalCreditedUnits, float TotalFees,
            float TuitionAmount, String TotalAssessment) {
        this.TuitionID = TuitionID;
        this.StudentID = StudentID;
        this.AYTerm = AYTerm;
        this.TotalTuitionUnits = TotalTuitionUnits;
        this.TotalCreditedUnits = TotalCreditedUnits;
        this.TotalFees = TotalFees;
        this.TuitionAmount = TuitionAmount;
        this.TotalAssessment = TotalAssessment;
    }

    public int getTuitionID() {
        return TuitionID;
    }

    public void setTuitionID(int TuitionID) {
        this.TuitionID = TuitionID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getAYTerm() {
        return AYTerm;
    }

    public void setAYTerm(String AYTerm) {
        this.AYTerm = AYTerm;
    }

    public float getTotalTuitionUnits() {
        return TotalTuitionUnits;
    }

    public void setTotalTuitionUnits(float TotalTuitionUnits) {
        this.TotalTuitionUnits = TotalTuitionUnits;
    }

    public float getTotalCreditedUnits() {
        return TotalCreditedUnits;
    }

    public void setTotalCreditedUnits(float TotalCreditedUnits) {
        this.TotalCreditedUnits = TotalCreditedUnits;
    }
    
    public float getTotalFees() {
        return TotalFees;
    }

    public void setTotalFees(float TotalFees) {
        this.TotalFees = TotalFees;
    }

    public float getTuitionAmount() {
        return TuitionAmount;
    }

    public void setTuitionAmount(float TuitionAmount) {
        this.TuitionAmount = TuitionAmount;
    }

    public String getTotalAssessment() {
        return TotalAssessment;
    }

    public void setTotalAssessment(String TotalAssessment) {
        this.TotalAssessment = TotalAssessment;
    }

}
