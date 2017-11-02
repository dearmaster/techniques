package com.master.techniques.aop.spring.xml;

public class StudentServiceImpl implements StudentService {

    @Override
    public void addStudent() {
        System.out.println("student added");
    }

    @Override
    public Student getStudent(int id) {
        if(id == 1)
            return new Student(1, "Lily", 22);
        return new Student(200, "unkown student", 50);
    }

    @Override
    public void delete() throws Exception {
        System.out.println(1/0);
    }

}