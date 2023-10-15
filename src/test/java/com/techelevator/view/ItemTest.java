package com.techelevator.view;

import com.techelevator.itemTypes.Drink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    private Item itemInStock;
    private Item itemOutOfStock;

    @Before
    public void setUp() {
        itemInStock = new Drink("D1", "Worm", 2.00, "Drink", 5);
        itemOutOfStock = new Drink("D1", "Worm", 2.00, "Drink", 0);
    }

    @Test
    public void testGetDisplayStringInStock() {
        String expected = "D1 | Worm | $2.00 | Drink | Stock: 5";
        String actual = itemInStock.getDisplayString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDisplayStringOutOfStock() {
        String expected = "D1 | Worm | $2.00 | Drink | Stock: SOLD OUT";
        String actual = itemOutOfStock.getDisplayString();
        Assert.assertEquals(expected, actual);

    }
}
