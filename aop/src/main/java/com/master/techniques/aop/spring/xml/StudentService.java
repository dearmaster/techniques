package com.master.techniques.aop.spring.xml;

public interface StudentService {

    void addStudent();

    Student getStudent(int id);

    void delete() throws Exception;

}