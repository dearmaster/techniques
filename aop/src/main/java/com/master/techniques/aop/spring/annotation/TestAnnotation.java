package com.master.techniques.aop.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfiguration.class);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.addEmployee();
    }

}