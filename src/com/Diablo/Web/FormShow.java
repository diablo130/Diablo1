package com.Diablo.Web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.util.List;

import com.Diablo.JDBC.DbUtiles;
import com.Diablo.JDBC.UserInfo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.util.*;
/**
 * Created by ���� on 2015/5/18.
 * function:�û�ע��У��
 */
@WebServlet(name = "FormShow",urlPatterns = "/src/com.Diablo.Web/FormShow")
public class FormShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        RequestDispatcher rd;
        /*response.setContentType("text/html;charset=GBK");*/
        String username = request.getParameter("user").trim();
        String password = request.getParameter("pwd").trim();

        QueryRunner qr = new QueryRunner();
        Connection conn=null;
        conn = DbUtiles.getConnection();
        List<UserInfo> ResultInfo=null;
        String sql = "SELECT * from information.�û�ע��� WHERE password='"+ password +"'";
        try {
            ResultInfo=(List<UserInfo>) qr.query(conn, sql, new BeanListHandler<UserInfo>(UserInfo.class));
            if (ResultInfo.size() == 0) {
                    String newUser = "insert into �û�ע���(username,password)values('" + username + " ','" + password + "')";
                    qr.update(conn, newUser);
                //��ȡsession����
                HttpSession session = request.getSession(true);
                //����session���ԣ������û��Ự״̬
                session.setAttribute("login","yes");
                session.setAttribute("myname" , username);
                //��ȡת������
                response.sendRedirect("/index.jsp");
            }
            else{
                UserInfo ui = (UserInfo) ResultInfo.get(0);
                if (ui.getUsername().equals(username)) {
                    System.out.println("�û����Ѿ�����");
                    response.sendRedirect("/index.jsp");
                }
                /*else {
                }*/
            }
        } catch (Exception e) {
            throw new RuntimeException("��ѯʧ��");
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
