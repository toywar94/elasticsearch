package com.project.pattern.observer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class MessageSubscriber implements Observer{

    private String name;

    @Override
    public void update(String message) {
        log.info("name {} received message : {}", name, message);
    }

}
