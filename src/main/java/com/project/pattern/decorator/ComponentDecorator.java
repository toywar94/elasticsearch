package com.project.pattern.decorator;

import com.project.pattern.decorator.car.Car;

public abstract class ComponentDecorator extends Car {

    Car car;

    public abstract String getDescription();

}
