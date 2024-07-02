/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import com.app.controller.CORController;
import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class GenerateCOR {
    public void generateCOR(){
        CORController cr = new CORController();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n**Generate COR**");
        System.out.print("Enter StudentID: ");
        int studid = sc.nextInt();
        
        cr.generateCOR(studid);
        
        
    }
}
