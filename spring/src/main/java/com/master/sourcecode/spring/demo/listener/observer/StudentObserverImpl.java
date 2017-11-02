package com.master.sourcecode.spring.demo.listener.observer;

public class StudentObserverImpl implements Observer {

    private Subject teacher;
    private String studentName;

    public StudentObserverImpl(Subject teacher, String studentName) {
        this.teacher = teacher;
        this.studentName = studentName;
        teacher.addObserver(this);
    }

    @Override
    public void update(String info) {
        System.out.println("Student + [" + studentName + "] get the homework: " + info);
    }

}