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
 * Created by ���� on 2015/5/25.
 * function����ͷ�ϵ��û��ǳ�У��
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/src/com.Diablo.Web/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");                   //������Ӧ����
        RequestDispatcher rd;
        HttpSession session = request.getSession(true);
        //����session���ԣ������û��Ự״̬
        session.setAttribute("login","no");
        response.sendRedirect("/index.jsp");

        /*response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
