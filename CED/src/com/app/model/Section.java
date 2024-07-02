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
public class Section {
    private String SectionCode;

    
    public Section(){
        
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
