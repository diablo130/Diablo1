package com.Diablo.JDBC;

/**
 * Created by »ÆËÚ on 2015/5/23.
 */

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtiles {
    private static Connection conn;
    public static Connection getConnection() {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/information?user=root&pass=admin";
        String username = "root";
        String password = "admin";
        Connection conn = null;
        DbUtils.loadDriver(driverClassName);
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}