package com.master.techniques.aop.theory.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;
    private Object inject;

    public Object bind(Object target, Object inject) {
        this.target = target;
        this.inject = inject;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = target.getClass().getMethod(method.getName()); //TODO
        MethodNeededAnnotation annotation = targetMethod.getDeclaredAnnotation(MethodNeededAnnotation.class);
        Method methodToInject;
        switch (annotation.value()) {
            case BEFORE:
                methodToInject = getMethod(inject, MethodAnnotation.MethodType.BEFORE);

                methodToInject.invoke(inject, null);
                method.invoke(target, args);
                break;
            case AFTER:
                methodToInject = getMethod(inject, MethodAnnotation.MethodType.AFTER);

                method.invoke(target, args);
                methodToInject.invoke(inject, null);
                break;
            case AROUND:
                methodToInject = getMethod(inject, MethodAnnotation.MethodType.AROUND);

                methodToInject.invoke(inject, null);
                method.invoke(target, args);
                methodToInject.invoke(inject, null);

                break;
        }

        return null;
    }

    private Method getMethod(Object inject, MethodAnnotation.MethodType methodType) {
        for(Method method : inject.getClass().getDeclaredMethods()) {
            MethodAnnotation annotation = method.getDeclaredAnnotation(MethodAnnotation.class);
            if(null != annotation && annotation.value().equals(methodType)) {
                return method;
            }
        }
        return null;
    }

}