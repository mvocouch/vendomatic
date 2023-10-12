package com.techelevator.itemTypes;

import com.techelevator.view.AsciiPrinter;
import com.techelevator.view.Item;

public class Candy extends Item {
    public Candy(String locationSlot, String name, double price, String itemType, int quantity) {
        super(locationSlot, name, price, itemType, quantity);
    }

    public Candy( String[] args, int quantity){super(args, quantity); }

    @Override
    public void displaySound() {
        AsciiPrinter.printASCII("asciiface.txt", false);
        System.out.println("Munch Munch, Yum!");
    }
}
