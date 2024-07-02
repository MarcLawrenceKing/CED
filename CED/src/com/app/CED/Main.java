/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.CED;

import com.app.view.Login;
import com.app.view.MainMenu;
import com.app.view.ReadMenu;

/**
 *
 * @author marclf
 */

public class Main extends DBConnection{
    public static void main(String[] args) {
        
        Login lg = new Login();
        MainMenu mm = new MainMenu();
        ReadMenu rm = new ReadMenu();
        
        mm.mainmenu();
    }
}
