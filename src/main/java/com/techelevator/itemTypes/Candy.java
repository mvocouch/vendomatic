package com.techelevator.itemTypes;

import com.techelevator.Items;

public class Candy extends Items {
    public Candy(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    @Override
    public String getItemType() {
        return super.getItemType();
    }

    @Override
    public void displaySound() {
        if (getItemType().equals("Candy")){
            System.out.println("Munch Munch, Yum!");
        }
    }
}
