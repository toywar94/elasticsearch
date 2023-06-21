package com.project.pattern.decorator.car;

public class Ferrari extends Car {

    public Ferrari(){
        description = "Ferrari";
    }

    @Override
    public double cost() {
        return 32000;
    }
}

