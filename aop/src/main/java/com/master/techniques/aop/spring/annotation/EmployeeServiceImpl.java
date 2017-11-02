package com.master.techniques.aop.spring.annotation;

import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void addEmployee() {
        System.out.println("employee added");
    }

    @Override
    public Employee getByName(String name) {
        if("lily".equalsIgnoreCase(name))
            return new Employee(1, "lily", 22);
        else
            return new Employee(200, "unknown employee", 50);
    }

    @Override
    public void deleteEmployee() throws Throwable {
        System.out.println(1/0);
    }

}