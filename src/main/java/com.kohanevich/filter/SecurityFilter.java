package com.kohanevich.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Denis on 6/12/2016
 */
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //NOP
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // TODO:
    }

    @Override
    public void destroy() {
        //NOP
    }
}
