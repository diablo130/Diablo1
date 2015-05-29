package com.Diablo.Listener; /**
 * Created by 黄粟 on 2015/5/29.
 * functions:测试session属性的增加，修改，删除事件
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class TestAttrListener implements
        HttpSessionListener, HttpSessionAttributeListener {
    Log log = LogFactory.getLog(getClass());
    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        HttpSession session = sbe.getSession();
        String name = sbe.getName();
        log.info("新建session属性：" + name +",值为："+ sbe.getValue());

        /*29-May-2015 15:14:45.066 INFO [http-apr-8080-exec-9] com.Diablo.Listener.TestAttrListener.attributeAdded 新建session属性：login,值为：yes
        29-May-2015 15:14:45.067 INFO [http-apr-8080-exec-9] com.Diablo.Listener.TestAttrListener.attributeAdded 新建session属性：myname,值为：diablo130*/
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        HttpSession session = sbe.getSession();
        String name = sbe.getName();
        log.info("删除session属性：" + name +",值为："+ sbe.getValue());

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        HttpSession session = sbe.getSession();
        String name = sbe.getName();
        Object oldValue=sbe.getValue();
        log.info("session属性：" + name +",老值为："+ sbe.getValue()+",新值为：" + session.getAttribute(name));
        /*29-May-2015 15:15:03.081 INFO [http-apr-8080-exec-5] com.Diablo.Listener.TestAttrListener.attributeReplaced session属性：login,老值为：yes,新值为：no*/
    }
}
