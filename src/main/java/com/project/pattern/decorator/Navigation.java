package com.project.pattern.decorator;

import com.project.pattern.decorator.car.Car;

public class Navigation extends ComponentDecorator {

    public Navigation(Car car){
        this.car = car;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Navigation";
    }

    @Override
    public double cost() {
        return car.cost() + 800;
    }
}
