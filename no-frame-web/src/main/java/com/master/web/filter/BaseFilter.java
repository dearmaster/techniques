package com.master.web.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class BaseFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(BaseFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("filter initialized: " + this.getClass().getSimpleName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("filtering: " + this.getClass().getSimpleName());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.debug("filter destroyed: " + this.getClass().getSimpleName());
    }

}