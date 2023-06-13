package com.project.pattern.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefensiveStrategy implements Strategy {

    @Override
    public void attackOpponent() {
        log.info("Execute Defensive Strategy");

    }
}
