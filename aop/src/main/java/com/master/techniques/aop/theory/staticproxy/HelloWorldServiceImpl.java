package com.master.techniques.aop.theory.staticproxy;

public class HelloWorldServiceImpl implements HelloService {

    @Override
    public void greet(String str) {
        System.out.println("Hello " + str);
    }

}