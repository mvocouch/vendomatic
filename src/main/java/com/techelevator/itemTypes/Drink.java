package com.techelevator.itemTypes;

import com.techelevator.mainClasses.AsciiPrinter;
import com.techelevator.mainClasses.Item;

public class Drink extends Item {
    public Drink(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    public Drink(String[] args, int quantity){ super(args, quantity); }

    @Override
    public String getItemType() {
        return super.getItemType();
    }

    @Override
    public void displaySound() {
        AsciiPrinter.printASCII("asciiface.txt", false);
        System.out.println(" Glug Glug, Yum!");
    }
}
