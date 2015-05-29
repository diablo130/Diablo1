package com.Diablo.Listener; /**
 * Created by ���� on 2015/5/29.
 * functions:���Էֱ����ServletContext��application����session��Request�Ľ���������
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class TestObjectListener implements ServletContextListener,HttpSessionListener,ServletRequestListener{
    Log log = LogFactory.getLog(getClass());
    // Public constructor is required by servlet spec
    public TestObjectListener() {
    }
    public void requestInitialized(ServletRequestEvent se) {
        HttpServletRequest request=(HttpServletRequest)se.getServletRequest();
        String uri=request.getRequestURI();
        uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());
        request.setAttribute("dataCreated", System.currentTimeMillis());
        log.info("����IP:" + request.getRemoteAddr());
    }

    public void requestDestroyed(ServletRequestEvent se) {
        HttpServletRequest request=(HttpServletRequest)se.getServletRequest();
        long time=System.currentTimeMillis()-(Long)request.getAttribute("dataCreated");
        log.info(request.getRemoteAddr() + "�����������ʱ��" + time + "����");
    }
    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ServletContext sc=sce.getServletContext();
        log.info("��������" + sc.getContextPath());
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        ServletContext sc=sce.getServletContext();
        log.info("��������" + sc.getContextPath());
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        HttpSession session=se.getSession();
        log.info("�½�һ��session��idΪ��" + session.getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        HttpSession session=se.getSession();
        log.info("����һ��session��idΪ��" + session.getId());
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }


}
