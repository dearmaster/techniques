package com.master.web.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestLog4j {

    private static final Logger logger = LogManager.getLogger(TestLog4j.class);

    public static void main(String[] args) {
        logger.info("test");
    }

}