package com.master.techniques.aop.spring.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

public class EmployeeServiceImplTest extends TestConfig {

    @Autowired
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addEmployee() throws Exception {
        employeeService.addEmployee();
    }

    @Test
    public void getByName() throws Exception {
        employeeService.getByName("lily");
    }

    @Test public void deleteEmployee() {
        try {
            employeeService.deleteEmployee();
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
        }
    }

}