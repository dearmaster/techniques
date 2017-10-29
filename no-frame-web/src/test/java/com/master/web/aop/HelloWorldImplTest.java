package com.master.web.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/aop.xml")
public class HelloWorldImplTest {

    @Autowired
    private HelloWorld helloWorld;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printHello() throws Exception {
        helloWorld.printHello();
    }

    @Test
    public void printWorld() throws Exception {
        helloWorld.printWorld();
    }

}