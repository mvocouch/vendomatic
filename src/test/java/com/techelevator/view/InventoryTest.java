package com.techelevator.view;

import com.techelevator.itemTypes.Candy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class InventoryTest {
    private Inventory inventory;

    @Before
    public  void setUp(){

        inventory = new Inventory();
    }
    @Test
    public void testCsvFileToMap() throws FileNotFoundException {
        Map<String, Item> expectedInventory = new HashMap<>();

        expectedInventory.put("B4", new Candy("B4", "Crunchie", 1.75, "Candy",5));

        Map<String, Item> actualInventory = inventory.getInventory();

        Item expectedItemB4 = expectedInventory.get("B4");
        Item actualItemB4 = actualInventory.get("B4");

        Assert.assertEquals(expectedItemB4.getLocationSlot(), actualItemB4.getLocationSlot());
        Assert.assertEquals(expectedItemB4.getName(), actualItemB4.getName());
        Assert.assertEquals(expectedItemB4.getPrice(), actualItemB4.getPrice(), 0.001);
        Assert.assertEquals(expectedItemB4.getItemType(), actualItemB4.getItemType());
    }
}
