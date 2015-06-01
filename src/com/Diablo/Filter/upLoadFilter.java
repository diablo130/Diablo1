package com.Diablo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by »ÆËÚ on 2015/5/29.
 */
/*@WebFilter(filterName = "upLoadFilter",urlPatterns = "")*/
public class upLoadFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UploadRequestWrapper uploadRequest = new UploadRequestWrapper((HttpServletRequest)req);
        chain.doFilter(uploadRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
