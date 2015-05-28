
package com.Diablo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;


/**
 * Created by ���� on 2015/5/26.
 * functions:����ҳ����뷽ʽ�Ĺ�����������ҳ����Ч
 */

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*",
        initParams = {@WebInitParam(name="characterEncoding",value="UTF-8"),
                @WebInitParam(name="enabled",value="true")})    //��ʼ������
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
        //��ȡ���ñ��뷽ʽ
        characterEncoding = config.getInitParameter("characterEncoding");
        //�Ƿ�����
        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled").trim());
    }

}

