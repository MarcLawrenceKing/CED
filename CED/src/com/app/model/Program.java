/*
 * The Program class is a Model responsible for the data logic and storing and retrieving data.
 * 
 * This class is being used in its own controller to allow manipulation of data.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.model;

public class Program {
    private String ProgramCode;
    private String ProgramDesc;
    private float MaxUnitsEnrolled;

    public Program() {

    }

    public Program(String ProgramCode, String ProgramDesc, float MaxUnitsEnrolled) {
        this.ProgramCode = ProgramCode;
        this.ProgramDesc = ProgramDesc;
        this.MaxUnitsEnrolled = MaxUnitsEnrolled;
    }

    public String getProgramCode() {
        return ProgramCode;
    }

    public void setProgramCode(String ProgramCode) {
        this.ProgramCode = ProgramCode;
    }

    public String getProgramDesc() {
        return ProgramDesc;
    }

    public void setProgramDesc(String ProgramDesc) {
        this.ProgramDesc = ProgramDesc;
    }

    public float getMaxUnitsEnrolled() {
        return MaxUnitsEnrolled;
    }

    public void setMaxUnitsEnrolled(float MaxUnitsEnrolled) {
        this.MaxUnitsEnrolled = MaxUnitsEnrolled;
    }

}
