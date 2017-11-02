package com.master.techniques.aop.spring.xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvise implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Around advise before");
        try {
            Object result = invocation.proceed();
            System.out.println("Around advise after");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}