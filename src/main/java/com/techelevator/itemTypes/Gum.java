package com.techelevator.itemTypes;

import com.techelevator.view.Item;

public class Gum extends Item {

    public Gum(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    public Gum(String[] parts, int quantity) { super(parts, quantity);}

    @Override
    public void displaySound(){
        System.out.println("Chew Chew, Yum!");
    }
}
