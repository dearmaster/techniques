package com.master.techniques.aop.spring.annotation;

public interface EmployeeService {

    void addEmployee();

    Employee getByName(String name);

    void deleteEmployee() throws Throwable;

}