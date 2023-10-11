package com.techelevator.itemTypes;

import com.techelevator.Item;

public class Candy extends Item {
    public Candy(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    public Candy( String[] args, int quantity){super(args, quantity); }

    @Override
    public void displaySound() {
        System.out.println("Munch Munch, Yum!");
    }
}
