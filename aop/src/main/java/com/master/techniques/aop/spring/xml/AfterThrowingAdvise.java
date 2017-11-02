package com.master.techniques.aop.spring.xml;

import org.springframework.aop.ThrowsAdvice;

public class AfterThrowingAdvise implements ThrowsAdvice {

    public void afterThrowing(Throwable exception) throws Throwable {
        System.out.println("After throwing advise");
    }

}
