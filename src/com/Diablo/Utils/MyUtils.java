package com.Diablo.Utils;

import org.apache.commons.dbutils.DbUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ª∆À⁄ on 2015/5/25.
 */
public class MyUtils {
    public static void Info(PrintWriter out,Boolean b,HttpServletRequest request) {                      //HTML–≈œ¢œ‘ æ
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Log Information</TITLE></HEAD>");
        out.println("<BODY>");

        if (b) {
            out.println("Welcome Back!"+request.getParameter("username"));
        }
        else{
            out.println("Login Failure!");
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    public static Connection MyConn(String url,String driver,String name,String pass)throws Exception{
        Connection c=null;
        String MydriverClassName = driver;
        String Myurl = url;
        String Myuser = name;
        String Mypass = pass;
        Connection conn = null;
        DbUtils.loadDriver(MydriverClassName);
        try {
            conn = DriverManager.getConnection(Myurl, Myuser, Mypass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  c;
    }

}
