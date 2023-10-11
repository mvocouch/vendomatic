package com.techelevator;

import com.techelevator.itemTypes.Candy;
import com.techelevator.itemTypes.Chip;
import com.techelevator.itemTypes.Drink;
import com.techelevator.itemTypes.Gum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Inventory {
    private static final int MAXIMUM_QUANTITY = 5;
    private SortedMap<String, Item> inventory;
    public Inventory() {
        csvFileToMap();
    }
    public SortedMap<String, Item> getInventory() {
        return inventory;
    }

    public void csvFileToMap(){
        String csvFilePath = "vendingmachine.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))){
            inventory = new TreeMap<>();
            String line;
            while ((line=br.readLine())!=null){
                String[] parts = line.split("\\|");
                if (parts.length == 4){
                    String locationSlot = parts[0].trim();
                    String itemType = parts[3].trim();
                    int quantity = MAXIMUM_QUANTITY;

                    Item item = null;
                    switch(itemType){
                        case "Candy":
                            item = new Candy(parts, quantity);
                            break;
                        case "Chip":
                            item = new Chip(parts, quantity);
                            break;
                        case "Drink":
                            item = new Drink(parts, quantity);
                            break;
                        case "Gum":
                            item = new Gum(parts, quantity);
                            break;
                    }

                    inventory.put(locationSlot,item);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void increaseItemQuantity(Map<String, Item> inventory, String locationSlot, int quantityToAdd) {
        Item item = inventory.get(locationSlot);
        if (item != null){
            int currentQuantity = item.getQuantity();
            int newQuantity = (currentQuantity+quantityToAdd);
            if (newQuantity > MAXIMUM_QUANTITY){
                System.out.println("QTY cannot exceed the maximum limit (" + MAXIMUM_QUANTITY + ").");
                item.setQuantity(MAXIMUM_QUANTITY);
            }else{
                item.setQuantity(newQuantity);
            }
        } else {
            System.out.println("Item with location slot '" + locationSlot + "' not found in inventory.");
        }
    }
    public void decreaseItemQuantity(Map<String, Item> inventory, String locationSlot, int quantityToSubtract) {
        Item item = inventory.get(locationSlot);
        if (item != null) {
            if (item.getQuantity() != 0) {
                int currentQuantity = item.getQuantity();
                int newQuantity = (currentQuantity - quantityToSubtract);
                if (newQuantity < 0) {
                    System.out.println("Insufficient stock of " + item.getName());
                } else {
                    item.setQuantity(newQuantity);
                }
            } else {
                System.out.println("Sold Out");
            }
        } else {
            System.out.println("Item with location slot '" + locationSlot + "' not found in inventory.");
        }
    }
    public void displayItems(){
        for (Item item: inventory.values()){
            System.out.println(item.getDisplayString());
        }
    }
}
