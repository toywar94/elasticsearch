package com.project.pattern.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

//Concrete Subject
@Slf4j
public class MessagePublisher implements Subject{

    private List<Observer> observerList;

    public MessagePublisher() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }

    public void sendMessage(String message) {
        log.info("Message Publisher: Sending message -> " + message);
        notifyObservers(message);
    }
}
