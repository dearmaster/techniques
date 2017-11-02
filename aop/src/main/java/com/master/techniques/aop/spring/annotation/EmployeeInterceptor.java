package com.master.techniques.aop.spring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeInterceptor {

    @Pointcut("execution(* com.master.techniques.aop.spring.annotation.EmployeeService.*(..))")
    private void anyMethod() {
    }

    @Before("anyMethod() && args(name)")
    public void getByName(String name) {
        System.out.println("Before Method: " + name);
    }

    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("After Returning");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("After Throwing");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("Enter around method");
        Object object = pjp.proceed();
        System.out.println("Exit around method");
        return object;
    }

}