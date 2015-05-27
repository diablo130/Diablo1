package com.Diablo.JDBC;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 黄粟 on 2015/5/18.
 */
@WebServlet(name = "JDBCServlet",urlPatterns = "/src/com.Rebecca.Web/JDBCServlet",initParams={
        @WebInitParam(name="driver", value="com.mysql.jdbc.Driver"),
        @WebInitParam(name="url", value="jdbc:mysql://localhost:3306/information?user=root&pass=admin"),
        @WebInitParam(name="user", value="root"),
        @WebInitParam(name="pass", value="admin")})
/*,initParams
        ={@WebInitParam(name="driver",value="com.mysql.jdbc.driver"),
@WebInitParam(name="url",value="jdbc:mysql://localhost:3306/information"),
@WebInitParam(name="user",value="root"),
@WebInitParam(name="pass",value="admin")}*/
public class JDBCServlet extends HttpServlet{

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /*//驱动程序名
            String driver = "com.mysql.jdbc.Driver";
            //数据库用户名
            String user = "root";
            //密码
            String Pass = "admin";
            //数据库名
            String dbName = "information";
            //表名
            String tableName = "公交数据表";
            //联结字符串
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
                    + user + "&password=" + Pass;*/
            request.setCharacterEncoding("GBK");
            ServletConfig config=getServletConfig();
            String driver = config.getInitParameter("driver");
            String url = config.getInitParameter("url");
            String user = config.getInitParameter("user");
            String pass = config.getInitParameter("pass");

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement state=conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT * FROM 公交数据表");

            response.setContentType("text/html;charSet=GBK");
            PrintStream out = new PrintStream(response.getOutputStream());
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DataBase Servlet</title>");
            out.print("<link rel='stylesheet' type='text/css' href='/Style/table.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>数据库查询结果</h1>");
            out.println("<table>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<td>"+rs.getString(5)+"</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            rs.close();
            conn.close();
        } catch (Exception e) {

        }

    }
    public void init (ServletConfig config)throws ServletException{
        super.init(config);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("dopost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("doget");
    }

}
