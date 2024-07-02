/*Establishes cpnnection to database */

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