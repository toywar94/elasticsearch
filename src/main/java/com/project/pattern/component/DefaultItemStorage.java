package com.project.pattern.component;

import java.util.ArrayList;

public abstract class DefaultItemStorage implements ItemStorage{

    private ArrayList<Item> items = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public int getAllPrice() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }
}
