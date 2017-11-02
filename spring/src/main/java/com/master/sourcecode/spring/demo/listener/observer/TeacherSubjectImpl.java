package com.master.sourcecode.spring.demo.listener.observer;

import java.util.ArrayList;
import java.util.List;

public class TeacherSubjectImpl implements Subject {

    //store all ther observers
    private List<Observer> observers=new ArrayList<Observer>();
    //store the state
    private String info;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(info);
        }
    }

    public void publishHomeWork(String info) {
        this.info = info;
        System.out.println("Teacher published the homework for today: " + info);
        this.notifyObservers();
    }

}