package com.project.pattern.decorator;

import com.project.pattern.decorator.car.Car;

public class Wheel extends ComponentDecorator {

    public Wheel(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Wheel";
    }

    @Override
    public double cost() {
        return car.cost() + 200;
    }
}
