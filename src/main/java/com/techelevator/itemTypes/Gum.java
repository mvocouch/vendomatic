package com.techelevator.itemTypes;

import com.techelevator.Item;

public class Gum extends Item {

    public Gum(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    @Override
    public String getItemType() {
        return super.getItemType();
    }

    @Override
    public void displaySound(){
        if (getItemType().equals("Gum")){
            System.out.println("Chew Chew, Yum!");
        }
    }
}
