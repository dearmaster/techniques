package com.master.asm.web.servlet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ArticleServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger(ArticleServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug(this.getClass().getSimpleName() + ".service invoked");
        super.service(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.debug("Servlet " + this.getClass().getSimpleName() + " initialized");
        super.init(config);
    }

}