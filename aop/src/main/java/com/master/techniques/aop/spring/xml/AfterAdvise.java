package com.master.techniques.aop.spring.xml;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdvise implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------ after advise ------");
        System.out.println("method: " + method.getName());
        System.out.println("args: " + args);
        System.out.println("target: " + target);
        System.out.println("return value: " + returnValue);
        System.out.println("---------------------------");
    }

}