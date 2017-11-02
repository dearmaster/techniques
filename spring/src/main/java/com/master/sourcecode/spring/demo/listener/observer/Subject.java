package com.master.sourcecode.spring.demo.listener.observer;


public interface Subject {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();

}