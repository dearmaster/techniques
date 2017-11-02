package com.master.dp.observer;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteObserver implements Observer {

    private static AtomicInteger currentAtomicId = new AtomicInteger(1);
    private Integer id;

    public ConcreteObserver() {
        id = currentAtomicId.getAndAdd(1);
    }

    @Override
    public void update() {
        System.out.println("Observer [" + id.intValue() + "] get updated");
    }

}