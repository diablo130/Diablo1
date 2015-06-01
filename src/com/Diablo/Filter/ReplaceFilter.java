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
 * Created by 黄粟 on 2015/5/28.
 * function:替换输入输出文件的内容
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
     * functions:设置过滤
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*实例化一个自定义的相应*/
        HttpCharacterResponseWrapper response = new HttpCharacterResponseWrapper((HttpServletResponse)resp);
        chain.doFilter(req, response);
        /*获取相应字符串，转化成字符数组*/
        String output = response.getCharArrayWriter().toString();
        /*替换*/
        for (Object obj : prop.keySet()) {
            String key = (String) obj;
            output = output.replace(key, prop.getProperty(key));
        }
        /*输出*/
        PrintWriter out = resp.getWriter();
        out.println(output);
    }

    /**
     *
     * @param config
     * @throws ServletException
     * functions:初始化文件并加载
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
