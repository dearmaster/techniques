package com.master.sourcecode.spring.demo.listener.observer;

public class DemoObserver {

    public static void main(String[] args) {
        TeacherSubjectImpl teacherSubject = new TeacherSubjectImpl();
        Observer observer1 = new StudentObserverImpl(teacherSubject, "Lily");
        Observer observer2 = new StudentObserverImpl(teacherSubject, "Steven");
        Observer observer3 = new StudentObserverImpl(teacherSubject, "Poly");

        teacherSubject.publishHomeWork("English speaking");

        teacherSubject.deleteObserver(observer1);
        teacherSubject.deleteObserver(observer2);
        teacherSubject.publishHomeWork("Chinese");
    }

}