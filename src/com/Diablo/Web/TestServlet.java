package com.Diablo.Web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by »ÆËÚ on 2015/5/18.
 */
@WebServlet(name = "TestServlet",urlPatterns = "/src/com.Diablo.Web/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = new PrintWriter(response.getWriter());
        HttpSession hs=request.getSession();
        hs.setAttribute("login","yes");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        hs.setAttribute("myname",name);
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("µÇÂ½³É¹¦");
        out.print("user:" + name);
        out.println("<a href='/Test.jsp'>abc</a>");
        out.println("</body>");
        out.println("</html>");

    }
}
