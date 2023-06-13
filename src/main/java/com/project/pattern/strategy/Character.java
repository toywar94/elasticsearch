package com.project.pattern.strategy;

import lombok.Setter;

@Setter
public class Character {

    private Strategy strategy;

    public void attackOpponent(){
        if (strategy != null){
            strategy.attackOpponent();
        }
    }

}
