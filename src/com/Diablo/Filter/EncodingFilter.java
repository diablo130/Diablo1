
package com.Diablo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;


/**
 * Created by 黄粟 on 2015/5/26.
 * functions:设置页面编码方式的过滤器，所有页面生效
 */

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*",
        initParams = {@WebInitParam(name="characterEncoding",value="UTF-8"),
                @WebInitParam(name="enabled",value="true")})    //初始化参数
public class EncodingFilter implements Filter {
    private String characterEncoding;
    private boolean enabled;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (enabled || characterEncoding != null) {
            req.setCharacterEncoding(characterEncoding);
            resp.setCharacterEncoding(characterEncoding);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //读取配置编码方式
        characterEncoding = config.getInitParameter("characterEncoding");
        //是否启用
        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled").trim());
    }

}

