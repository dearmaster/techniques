package com.master.techniques.aop.spring.xml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

public class StudentServiceImplTest {

    private StudentService studentService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("advise-sample.xml");
        studentService = (StudentService) context.getBean("studentServiceProxy");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addStudent() throws Exception {
        studentService.addStudent();
    }

    @Test
    public void getStudent() throws Exception {
        studentService.getStudent(2);
    }

    @Test
    public void deleteStudent() {
        try {
            studentService.delete();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}