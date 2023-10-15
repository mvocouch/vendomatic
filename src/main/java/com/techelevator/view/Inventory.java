package com.techelevator.view;

import com.techelevator.itemTypes.Candy;
import com.techelevator.itemTypes.Chip;
import com.techelevator.itemTypes.Drink;
import com.techelevator.itemTypes.Gum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Inventory {
    private static final int MAXIMUM_QUANTITY = 5;
    private SortedMap<String, Item> inventory;
    public Inventory() {
        csvFileToMap();
    }

    public SortedMap<String, Item> getInventory() {
        return inventory;
    }

    public Item getItem(String slotID){
        return inventory.get(slotID);
    }

    public List<String> getLocationSlots(){
        return new ArrayList<>(inventory.keySet());
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

    public void displayItems(){
        System.out.print(System.lineSeparator());
        for (Item item: inventory.values()){
            System.out.println(item.getDisplayString());
        }
    }
}
