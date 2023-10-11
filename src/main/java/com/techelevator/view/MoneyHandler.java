package com.techelevator.view;

import com.techelevator.customExceptions.InsufficientBalanceException;

import java.text.DecimalFormat;

public class MoneyHandler {
    private double balance;
    private double moneyReturned;

    private static final double ONE_DOLLAR = 1.00;
    private static final double FIVE_DOLLAR = 5.00;
    private static final double TEN_DOLLAR = 10.00;
    private static final double QUARTER = 0.25;
    private static final double DIME = 0.10;
    private static final double NICKLE = 0.05;
    private static final double PENNY = 0.01;

    public MoneyHandler() {
        this.balance = 0;

    }

    public double getBalance() {
        return balance;
    }

    public double getMoneyReturned() {
        return moneyReturned;
    }
    public void setMoneyReturned(double moneyReturned) {
        this.moneyReturned = moneyReturned;
    }
    public void addToBalance(int amount){
        this.balance += amount;
    }
    public void subtractFromBalance(double amount) throws InsufficientBalanceException {
        if (this.balance - amount >= 0){
            balance -= amount;
        } else {
            throw new InsufficientBalanceException(System.lineSeparator() + "Insufficient balance to purchase selected item.");
        }
    };
    public static String doubleToString(double money){
        return new DecimalFormat("0.00").format(money);
    }

    public void transaction(){

    }


}
