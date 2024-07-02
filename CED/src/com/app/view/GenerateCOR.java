/*
 * The Generate class contains the GUI to present the COR generation section.
 * 
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.view;

import com.app.controller.CORController;
import java.util.Scanner;

/**
 *
 * @author marcl
 */
public class GenerateCOR {
    public void generateCOR() {
        CORController cr = new CORController();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n**Generate COR**");
        System.out.print("Enter StudentID: ");
        int studid = sc.nextInt();

        cr.generateCOR(studid);

    }
}
