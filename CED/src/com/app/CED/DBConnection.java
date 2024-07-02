package com.app.CED;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

    final static String URL = "jdbc:mysql://localhost:3306/cor_db";
    final static String USERNAME = "root";
    final static String PASSWORD = "";
    final static String DRIVER = "com.mysql.jdbc.Driver";
    
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