package com.project.pattern.decorator.car;


import com.project.pattern.decorator.Size;

public abstract class Car {

    Size size;

    String description = "";

    public void setSize(Size size){
        this.size = size;
    }

    public Size getSize(){
        return this.size;
    }

    public String getDescription(){
        return description;
    }

    public abstract double cost();


}
