package com.master.techniques.aop.theory.dynamicproxy;

public class Authentication {

    @MethodAnnotation(MethodAnnotation.MethodType.BEFORE)
    public void authenticationBefore() {
        System.out.println("authentication before");
    }

    @MethodAnnotation(MethodAnnotation.MethodType.AFTER)
    public void authenticationAfter() {
        System.out.println("authentication after");
    }

    @MethodAnnotation(MethodAnnotation.MethodType.AROUND)
    public void authenticationAround() {
        System.out.println("authentication around");
    }

}