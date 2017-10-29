package com.master.web.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TimeHandler {

    private static final Logger logger = LogManager.getLogger(TimeHandler.class);

    public void printTime() {
        logger.info("current time: " + System.currentTimeMillis());
    }

}