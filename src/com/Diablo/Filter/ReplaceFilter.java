package com.Diablo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by 黄粟 on 2015/5/28.
 * function:替换输入输出文件的内容
 */
/*@WebFilter(filterName = "ReplaceFilter", urlPatterns = "*//*",
           initParams = {@WebInitParam(name="file",value="")})

public class ReplaceFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}*/
