package com.master.techniques.aop.theory.dynamicproxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodNeededAnnotation {

    enum MethodType {
        BEFORE,
        AFTER,
        AROUND
    }

    MethodType value();

}