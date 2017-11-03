package com.master.asm.web;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class WebAppBeanListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
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