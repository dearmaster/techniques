package com.master.web.aop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HelloWorldImpl implements HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorldImpl.class);

    @Override
    public void printHello() {
        logger.info("Hello");
    }

    @Override
    public void printWorld() {
        logger.info("World");
    }
}