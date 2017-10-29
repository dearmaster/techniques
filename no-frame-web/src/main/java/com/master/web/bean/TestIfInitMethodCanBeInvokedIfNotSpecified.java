package com.master.web.bean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestIfInitMethodCanBeInvokedIfNotSpecified {

    private static final Logger logger = LogManager.getLogger(TestIfInitMethodCanBeInvokedIfNotSpecified.class);

    public void init() {
        logger.debug("init method invoked: " + this.getClass().getSimpleName());
    }

}