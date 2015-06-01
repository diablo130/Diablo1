package com.Diablo.Filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 黄粟 on 2015/5/29.
 * function:重写HttpServletResponseWrapper
 */
public class HttpCharacterResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter charArrayWriter=new CharArrayWriter();

    public HttpCharacterResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    public PrintWriter getWriter() throws IOException {     //覆盖该方法，输出一个字符数组Writer
        return new PrintWriter(charArrayWriter);
    }

    public CharArrayWriter getCharArrayWriter() {
        return charArrayWriter;
    }
}
