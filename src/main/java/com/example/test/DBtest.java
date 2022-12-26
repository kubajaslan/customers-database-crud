package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBtest {


    public static void main(String[] args) {
        String user = "b1099c657bf341";
        String pass = "47fd372a";

        String url = "jdbc:mysql://b1099c657bf341:47fd372a@eu-cdbr-west-03.cleardb.net/heroku_8c577137f27a35f?reconnect=true";

        try {

            Connection myConn = DriverManager.getConnection(url, user, pass);

            System.out.println("success");

            myConn.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
