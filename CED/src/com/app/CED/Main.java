/*
 * The Main class is where the entire program starts.
 *
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.CED;

import com.app.view.Login;
import com.app.view.MainMenu;
import com.app.view.ReadMenu;

public class Main extends DBConnection {
    public static void main(String[] args) {

        Login lg = new Login();
        MainMenu mm = new MainMenu();
        ReadMenu rm = new ReadMenu();

        mm.mainmenu();
    }
}
