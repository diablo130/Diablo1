package com.Diablo.Web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;

/**
 * Created by »ÆËÚ on 2015/5/18.
 */
/*@WebServlet(loadOnStartup = 1,name = "TimerServlet")*/
public class TimerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

        public void init(ServletConfig config)throws ServletException
        {
            /*super.init(config);
            Timer t = new Timer(1000,new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.out.println(new Date());
                }
            });
            t.start();*/
        }
    }

