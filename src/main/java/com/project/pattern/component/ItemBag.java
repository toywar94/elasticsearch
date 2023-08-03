package com.project.pattern.component;

public class ItemBag extends DefaultItemStorage implements Item{

    private final int price;
    private final String name;

    public ItemBag(int price, String name){
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return this.getAllPrice() + this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
