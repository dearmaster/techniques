package com.master.asm.web.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Equals to ContextLoaderListener in web.xml
 */
public class SimpleWebAppInitializer implements WebApplicationInitializer {

    private static final Logger logger = LogManager.getLogger(SimpleWebAppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        AnnotationConfigWebApplicationContext webContext=new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",new DispatcherServlet(webContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}