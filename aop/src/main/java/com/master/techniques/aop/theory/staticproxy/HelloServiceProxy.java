package com.master.techniques.aop.theory.staticproxy;

public class HelloServiceProxy implements HelloService {

    private HelloService service;

    public HelloServiceProxy(HelloService service) {
        this.service = service;
    }

    @Override
    public void greet(String str) {
        Log.logBefore();
        service.greet(str);
        Log.logAfter();
    }

}