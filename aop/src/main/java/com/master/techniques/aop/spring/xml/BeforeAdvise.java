package com.master.techniques.aop.spring.xml;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvise implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------ before advise ------");
        System.out.println("method: " + method.getName());
        System.out.println("args: " + args);
        System.out.println("target: " + target);
        System.out.println("---------------------------");
    }

}