package com.techelevator.itemTypes;

import com.techelevator.Item;

public class Drink extends Item {
    public Drink(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    @Override
    public String getItemType() {
        return super.getItemType();
    }

    @Override
    public void displaySound() {
        if (getItemType().equals("Drink")){
            System.out.println("Glug Glug, Yum!");
        }
    }
}
