package com.project.pattern.component;

public class DefaultItem implements Item{

    private final int price;
    private final String name;

    public DefaultItem(int price, String name){
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
