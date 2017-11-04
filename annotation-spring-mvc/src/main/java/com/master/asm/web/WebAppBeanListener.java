package com.master.asm.web;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WebAppBeanListener implements ApplicationListener<ContextRefreshedEvent> {

    private ContextRefreshedEvent event;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.event = event;
        if(null == event.getApplicationContext().getParent()) {
            String[] beanNames = event.getApplicationContext().getBeanDefinitionNames();
            Arrays.sort(beanNames);
            System.out.println("---------  beans defined ---------");
            for(String beanName : beanNames) {
                if(!beanName.startsWith("org."))
                    System.out.println(beanName);
            }
            System.out.println();
            System.out.println("----------------------------------");
        }
    }

}