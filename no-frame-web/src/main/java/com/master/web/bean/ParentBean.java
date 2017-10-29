package com.master.web.bean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ParentBean {

    private static final Logger logger = LogManager.getLogger(ParentBean.class);

    public ParentBean() {
        logger.debug("Bean Created: " + this);
    }

}