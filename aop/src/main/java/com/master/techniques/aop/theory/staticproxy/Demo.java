package com.master.techniques.aop.theory.staticproxy;

public class Demo {

    public static void main(String[] args) {
        HelloService service = new HelloServiceProxy(new HelloWorldServiceImpl());
        service.greet("Lucy");
    }

}