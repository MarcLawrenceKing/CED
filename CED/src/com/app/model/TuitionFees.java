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
public class TuitionFees {
    private int TuitionFeesID;
    private int TuitionID;
    private String FeeName;

    public TuitionFees() {

    }

    public TuitionFees(int TuitionFeesID, int TuitionID, String FeeName) {
        this.TuitionFeesID = TuitionFeesID;
        this.TuitionID = TuitionID;
        this.FeeName = FeeName;
    }

    public int getTuitionFeesID() {
        return TuitionFeesID;
    }

    public void setTuitionFeesID(int TuitionFeesID) {
        this.TuitionFeesID = TuitionFeesID;
    }

    public int getTuitionID() {
        return TuitionID;
    }

    public void setTuitionID(int TuitionID) {
        this.TuitionID = TuitionID;
    }

    public String getFeeName() {
        return FeeName;
    }

    public void setFeeName(String FeeName) {
        this.FeeName = FeeName;
    }

}
