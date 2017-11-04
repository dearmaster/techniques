//package com.master.asm.web.config;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//
///**
// * Equals to ContextLoaderListener in web.xml
// */
//public class SimpleWebAppInitializerBak extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    private static final Logger logger = LogManager.getLogger(SimpleWebAppInitializer.class);
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[] {AppConfig.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[] {WebConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return new Filter[] {characterEncodingFilter};
//    }
//}