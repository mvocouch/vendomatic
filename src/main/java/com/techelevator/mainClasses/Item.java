package com.techelevator.mainClasses;

import com.techelevator.customExceptions.OutOfStockException;



public abstract class Item {

    private final String locationSlot;
    private final String name;
    private final double price;
    private final String itemType;
    private int quantity;

    public Item(String locationSlot, String name, double price, String itemType, int quantity) {
        this.locationSlot = locationSlot;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.quantity = quantity;
    }

    public Item(String[] args, int quantity){
        this.locationSlot = args[0].trim();
        this.name = args[1].trim();
        this.price = Double.parseDouble(args[2].trim());
        this.itemType = args[3].trim();
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {return price;}
    public String getItemType() {
        return itemType;
    }
    public String getLocationSlot() {
        return locationSlot;
    }

    public void dispense(double availableBalance) throws OutOfStockException {
        if (quantity - 1 >= 0 & availableBalance >= price){
            quantity -= 1;
            System.out.println(System.lineSeparator() + "Dispensing " + name + " for $" +
                    MoneyHandler.doubleToString(price));
            displaySound();
            System.out.println("Your remaining balance is $" + MoneyHandler.doubleToString(availableBalance - price));

        } else if (quantity - 1 < 0) {
            throw new OutOfStockException(System.lineSeparator() + "*** The selected product is SOLD OUT. ***");
        }
    }

    public abstract void displaySound();

    public String getDisplayString() {
        String quantity = this.quantity == 0 ? "SOLD OUT" : String.valueOf(this.quantity);
        return locationSlot +
                " | " + name +
                " | $" +
                MoneyHandler.doubleToString(price) +
                " | " + itemType +
                " | Stock: " + quantity;
    }
}