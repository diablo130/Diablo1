package lee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@WebServlet(name="login"
        , urlPatterns={"/login"})
public class LoginServlet extends HttpServlet
{
    //��Ӧ�ͻ�������ķ���
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException,IOException
    {
        String errMsg = "";
        //Servlet�����������Ӧ���ͻ��ˣ���˱��뽫����ת��
        RequestDispatcher rd;
        //��ȡ�������
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        try
        {
            //Servlet��������ִ���κε�ҵ���߼�����������JavaBean�����û�����
            DbDao dd = new DbDao("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/information","root","admin");
            //��ѯ�����
            ResultSet rs = dd.query("select password from �û�ע��� where username = ?", username);
            if (rs.next())
            {
                //�û���������ƥ��
                if (rs.getString("password").equals(pass))
                {
                    //��ȡsession����
                    HttpSession session = request.getSession(true);
                    //����session���ԣ������û��Ự״̬
                    session.setAttribute("name" , username);
                    //��ȡת������
                    rd = request.getRequestDispatcher("/welcome.jsp");
                    //ת������
                    rd.forward(request,response);
                }
                else
                {
                    //�û��������벻ƥ��ʱ
                    errMsg += "�����û������벻����,����������";
                }
            }
            else
            {
                //�û���������ʱ
                errMsg += "�����û���������,����ע��";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //�������ת�������µ�¼
        if (errMsg != null && !errMsg.equals(""))
        {
            rd = request.getRequestDispatcher("/login.jsp");
            request.setAttribute("err" , errMsg);
            rd.forward(request,response);
        }
    }
}
