package com.techelevator;

public class Item {

    private String locationSlot;
    private String name;
    private double price;
    private String itemType;
    private int quantity;

    public Item(String locationSlot, String name, double price, String itemType, int quantity) {
        this.locationSlot = locationSlot;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.quantity = quantity;
    }

    public Item(){
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocationSlot() {
        return locationSlot;
    }
    public void setLocationSlot(String locationSlot) {
        this.locationSlot = locationSlot;
    }

    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displaySound(){
        String displaySound = "";
        System.out.println(displaySound);
    }

}