/*
 * The Main class is where the entire program starts.
 *
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.CED;

import com.app.view.LandingPage;


public class Main extends DBConnection {
    public static void main(String[] args) {
                
        LandingPage lp = new LandingPage();
        
        lp.show();
    }
}
