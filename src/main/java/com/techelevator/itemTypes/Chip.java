package com.techelevator.itemTypes;

import com.techelevator.Item;

public class Chip extends Item {
    public Chip(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    @Override
    public String getItemType() {
        return super.getItemType();
    }

    @Override
    public void displaySound() {
        if (getItemType().equals("Chip")){
            System.out.println("Crunch Crunch, Yum!");
        }
    }
}
