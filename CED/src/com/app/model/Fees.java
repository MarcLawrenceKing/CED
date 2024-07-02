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
public class Fees {
    private String FeeName;
    private float Amount;
    
    public Fees(){
        
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
