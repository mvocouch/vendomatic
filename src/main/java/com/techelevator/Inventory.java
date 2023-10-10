package com.techelevator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Items> inventory;
    public Inventory() {

    }
    public Map<String, Items> getInventory() {
        return inventory;
    }

    public static void CSVFileToHashMap(String[] args){
        String csvFilePath = "vendingmachine.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))){
            Map<String, Items> inventory = new HashMap<>();
            String line;
            while ((line=br.readLine())!=null){
                String[] parts = line.split("\\|");
                if (parts.length == 4){
                    String locationSlot = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String itemType = parts[3].trim();
                    int quantity = 5;

                    Items item = new Items(locationSlot, name, price, itemType, quantity);
                    inventory.put(locationSlot,item);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void increaseItemQuantity(Map<String,Items> inventory, String locationSlot, int quantityToAdd) {
        Items item = inventory.get(locationSlot);
        if (item != null){
            int currentQuantity = item.getQuantity();
            int newQuantity = (currentQuantity+quantityToAdd);
            if (newQuantity > 5){
                System.out.println("QTY cannot exceed the maximum limit (5).");
            }else{
                item.setQuantity(newQuantity);
            }
        } else {
            System.out.println("Item with location slot '" + locationSlot + "' not found in inventory.");
        }
    }
    public static void decreaseItemQuantity(Map<String,Items> inventory, String locationSlot, int quantityToSubtract) {
        Items item = inventory.get(locationSlot);
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
}
