package com.master.techniques.aop.theory.dynamicproxy;

public class Log {

    @MethodAnnotation(MethodAnnotation.MethodType.BEFORE)
    public void logBefore() {
        System.out.println("log before");
    }

    @MethodAnnotation(MethodAnnotation.MethodType.AFTER)
    public void logAfter() {
        System.out.println("log after");
    }

    @MethodAnnotation(MethodAnnotation.MethodType.AROUND)
    public void logAround() {
        System.out.println("log around");
    }

}