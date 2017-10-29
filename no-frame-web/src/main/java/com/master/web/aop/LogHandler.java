package com.master.web.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogHandler {

    private static final Logger logger = LogManager.getLogger(LogHandler.class);

    public void logBefore() {
        logger.info("log before method");
    }

    public void logAfter() {
        logger.info("log after method");
    }

}