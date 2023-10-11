package com.techelevator.itemTypes;

import com.techelevator.view.Item;

public class Chip extends Item {
    public Chip(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }
    public Chip(String[] args, int quantity){
        super(args, quantity);
    }
    @Override
    public void displaySound() {
        System.out.println("Crunch Crunch, Yum!");
    }
}
