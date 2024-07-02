/*
 * The TuitionFees class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

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
