/*
 * The DBConnection class establishes a database connection using JDBC.
 * it uses JDBC to interact with the MySQL database and provides a centralized 
 * location for managing database connections and operations throughout the system
 * 
 * This class is being implemented by ALL controllers  
 *
 * @authors Cedric Mangasi, Dominic Aldas, Marc King, Sheila Orapa
 *
 * @version 07/02/2024
 */
package com.app.CED;

import com.app.model.QueryConstant;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection implements QueryConstant {

    protected static Connection con;
    protected static PreparedStatement prep;
    protected static Statement state;
    protected static ResultSet result;

    public static void connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}