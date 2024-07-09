/*
 * The Scholarship class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public class Scholarship {

    private String Scholarship;

    public Scholarship() {

    }

    public Scholarship(String Scholarship) {
        this.Scholarship = Scholarship;
    }

    public String getScholarship() {
        return Scholarship;
    }

    public void setScholarship(String Scholarship) {
        this.Scholarship = Scholarship;
    }

}
