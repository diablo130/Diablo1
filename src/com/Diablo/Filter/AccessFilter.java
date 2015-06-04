package com.Diablo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 黄粟 on 2015/6/3.
 * function:登录过滤器，没有登录的用户只能在index.jsp观看
 */
@WebFilter(filterName = "AccessFilter",urlPatterns = "/showdata.jsp")
public class AccessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) req;
        HttpServletResponse hsp=(HttpServletResponse)resp;
        HttpSession httpSession=hsr.getSession();
        String path=hsr.getRequestURI();
        System.out.println("访问路径:"+path);
        if(!path.endsWith("/index.jsp")) {
            String status = (String) httpSession.getAttribute("login");
            System.out.println("登录状态:" + status);
            if ("yes".equals(status)) {
                chain.doFilter(req, resp);
            } else {
                hsp.sendRedirect("/index.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
