/*
 * The Section class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public class Section {
    private String SectionCode;

    public Section() {

    }

    public Section(String SectionCode) {
        this.SectionCode = SectionCode;
    }

    public String getSectionCode() {
        return SectionCode;
    }

    public void setSectionCode(String SectionCode) {
        this.SectionCode = SectionCode;
    }

}
