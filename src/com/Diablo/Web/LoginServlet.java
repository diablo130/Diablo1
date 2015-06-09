package com.Diablo.Web;

import com.Diablo.JDBC.DbUtiles;
import com.Diablo.JDBC.UserInfo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 黄粟 on 2015/5/15.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/src/com.Diablo.Web/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                   //设置响应参数
        RequestDispatcher rd;
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String path=request.getRequestURI();
        QueryRunner qr = new QueryRunner();
        Connection conn=null;
        conn = DbUtiles.getConnection();
        List<UserInfo> ResultInfo=null;
        HttpSession session = request.getSession(true);
        String sql = "SELECT * from information.用户注册表 WHERE password='"+ password +"'";
        try {
            ResultInfo=(List<UserInfo>) qr.query(conn, sql, new BeanListHandler<UserInfo>(UserInfo.class));
            if (ResultInfo.size() != 0) {                   //用户不存在
                UserInfo ui = (UserInfo) ResultInfo.get(0);
                if (ui.getUsername().equals(username)) {
                    //获取session对象
                    //设置session属性，跟踪用户会话状态
                    session.setAttribute("login","yes");
                    session.setAttribute("myname" , username);
                    /*
                    //获取转发对象
                    rd = request.getRequestDispatcher("/index.jsp");                    //跳转路径
                    //转发请求
                    rd.forward(request,response);*/

                    response.sendRedirect("/index.jsp");
                    System.out.print(request.getServletPath() + ".....path:" + request.getRequestURI() + "...." + request.getRequestURL()
                            + "..." + request.getLocalAddr());
                }
                else {
                    session.setAttribute("login","no");
                    response.sendRedirect("/index.jsp");
                }
            }
            else {
                session.setAttribute("login","no");
                /*request.setAttribute("username","");
                request.setAttribute("password","");*/
                //获取转发对象
                response.sendRedirect("/index.jsp");
                //转发请求

            }
        } catch (Exception e) {
            throw new RuntimeException("Failure");
        }
        finally {
            if (conn != null) {
                DbUtils.closeQuietly(conn);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
