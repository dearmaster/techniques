package com.master.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AntBuildDemo {
	
	private static final Logger logger = LogManager.getLogger(AntBuildDemo.class);
	
	public static void print(String msg) {
		logger.info("logger output test, message: " + msg);
	}
	
	public static void main(String[] args) {
		print(args[0]);
	}

}