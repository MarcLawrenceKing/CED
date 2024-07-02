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
public class Program {
    private String ProgramCode;
    private String ProgramDesc;
    private float MaxUnitsEnrolled;
    
    public Program(){
        
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
