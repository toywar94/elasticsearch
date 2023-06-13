package com.project.pattern.observer;

// Observable
public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String message);

}
