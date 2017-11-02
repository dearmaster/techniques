package com.master.techniques.aop.spring.annotation;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * This listener is to tracing the beans loaded in this project
 */
@Component
public class ContextRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //The root container is spring container
        if(null == event.getApplicationContext().getParent()) {
            String[] beanNames = event.getApplicationContext().getBeanDefinitionNames();
            System.out.println("---------  beans defined ---------");
            for(String beanName : beanNames)
                System.out.println(beanName);
            System.out.println();
            System.out.println("----------------------------------");
        }
    }

}