package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBtest {


    public static void main(String[] args) {
        String user = "springstudent";
        String pass = "springstudent";

        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

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
