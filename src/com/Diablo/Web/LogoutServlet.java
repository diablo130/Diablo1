package com.Diablo.Web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 黄粟 on 2015/5/25.
 * function：表头上的用户登出校验
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/src/com.Diablo.Web/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                   //设置响应参数
        RequestDispatcher rd;
        HttpSession session = request.getSession(true);
        //设置session属性，跟踪用户会话状态
        session.setAttribute("login","no");
        response.sendRedirect("/index.jsp");

        /*response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
