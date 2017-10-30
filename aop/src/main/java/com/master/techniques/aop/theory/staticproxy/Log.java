package com.master.techniques.aop.theory.staticproxy;

public class Log {

    public static void logBefore() {
        System.out.println("Before execution, time is: " + System.currentTimeMillis());
    }

    public static void logAfter() {
        System.out.println("After execution, time is: " + System.currentTimeMillis());
    }

}