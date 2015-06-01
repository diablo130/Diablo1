package com.Diablo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by ���� on 2015/5/28.
 * function:�滻��������ļ�������
 */
// @WebFilter(filterName = "ReplaceFilter", urlPatterns = "/*", initParams = {@WebInitParam(name="file",value="")})

public class ReplaceFilter implements Filter {
    private Properties prop = new Properties();
    public void destroy() {
    }

    /**
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     * functions:���ù���
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*ʵ����һ���Զ������Ӧ*/
        HttpCharacterResponseWrapper response = new HttpCharacterResponseWrapper((HttpServletResponse)resp);
        chain.doFilter(req, response);
        /*��ȡ��Ӧ�ַ�����ת�����ַ�����*/
        String output = response.getCharArrayWriter().toString();
        /*�滻*/
        for (Object obj : prop.keySet()) {
            String key = (String) obj;
            output = output.replace(key, prop.getProperty(key));
        }
        /*���*/
        PrintWriter out = resp.getWriter();
        out.println(output);
    }

    /**
     *
     * @param config
     * @throws ServletException
     * functions:��ʼ���ļ�������
     */
    public void init(FilterConfig config) throws ServletException {
        String f="web/File/conf/1.txt";
        String realPath = config.getServletContext().getRealPath(f);
        try {
            prop.load(new FileInputStream(realPath));
        } catch (Exception e) {
        }
    }

}
