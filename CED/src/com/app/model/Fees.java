/*
 * The Fees class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public class Fees {
    private String FeeName;
    private float Amount;

    public Fees() {

    }

    public Fees(String FeeName, float Amount) {
        this.FeeName = FeeName;
        this.Amount = Amount;
    }

    public String getFeeName() {
        return FeeName;
    }

    public void setFeeName(String FeeName) {
        this.FeeName = FeeName;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

}
