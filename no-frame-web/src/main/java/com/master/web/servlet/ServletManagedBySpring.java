package com.master.web.servlet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ServletManagedBySpring extends BaseServlet {

    private static final Logger logger = LogManager.getLogger(ServletManagedBySpring.class);

    public ServletManagedBySpring() {
        logger.debug("Servlet Created: " + this);
    }
}