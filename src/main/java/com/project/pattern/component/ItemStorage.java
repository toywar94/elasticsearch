package com.project.pattern.component;

public interface ItemStorage {
    void addItem(Item item);
    void removeItem(Item item);
    int getAllPrice();
}
