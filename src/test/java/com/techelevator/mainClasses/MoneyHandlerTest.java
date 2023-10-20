package com.techelevator.mainClasses;

import com.techelevator.customExceptions.InvalidFormOfPayment;
import com.techelevator.customExceptions.InsufficientBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MoneyHandlerTest {
    private MoneyHandler moneyHandler;

    @Before
    public  void setUp(){
        moneyHandler = new MoneyHandler();
        moneyHandler.setBalance(10);
    }
    @Test
    public void testAddToBalanceWithPositiveAmount() throws InvalidFormOfPayment {
        int initialBalance = (int) moneyHandler.getBalance();
        int amountToAdd = 50;

        moneyHandler.addToBalance(amountToAdd);

        assertEquals(initialBalance + amountToAdd, moneyHandler.getBalance(), 0.001);
    }

    @Test
    public void testAddToBalanceWithNegativeAmount() {
        int initialBalance = (int) moneyHandler.getBalance();
        int amountToAdd = -50;

        assertThrows(InvalidFormOfPayment.class, () -> {
            moneyHandler.addToBalance(amountToAdd);
        });

        assertEquals(initialBalance, moneyHandler.getBalance(),0.001);
    }

    @Test
    public void testSubtractFromBalanceWithSufficientBalance() throws InsufficientBalanceException {
        double initialBalance = moneyHandler.getBalance();
        double amountToSubtract = 2;

        moneyHandler.subtractFromBalance(amountToSubtract);

        assertEquals(initialBalance - amountToSubtract, moneyHandler.getBalance(), 0.001); // Use delta for double comparison
    }

    @Test
    public void testSubtractFromBalanceWithInsufficientBalance() {
        moneyHandler.setBalance(0);
        double initialBalance = moneyHandler.getBalance();
        double amountToSubtract = initialBalance + 10.0;

        assertThrows(InsufficientBalanceException.class, () -> {
            moneyHandler.subtractFromBalance(amountToSubtract);
        });

        assertEquals(initialBalance, moneyHandler.getBalance(), 0.001); // Use delta for double comparison
    }
}
