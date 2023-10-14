package com.techelevator.view;

import com.techelevator.customExceptions.InsufficientBalanceException;
import com.techelevator.customExceptions.InvalidFormOfPayment;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MoneyHandler {
    private double balance;
    private static final double QUARTER = .25;
    private static final double DIME = .10;
    private static final double NICKLE = .05;

    public MoneyHandler() {
        this.balance = 0;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToBalance(int amount) throws InvalidFormOfPayment {
        if (amount >= 0){
            this.balance += amount;
        } else {
            throw new InvalidFormOfPayment(System.lineSeparator() + "*** Invalid form of payment. ***");
        }
    }

    public void subtractFromBalance(double amount) throws InsufficientBalanceException {
        if (this.balance - amount >= 0){
            balance -= amount;
        } else {
            throw new InsufficientBalanceException(System.lineSeparator() + "*** Insufficient balance to purchase selected item. ***");
        }
    }

    public static String doubleToString(double money){
        return new DecimalFormat("0.00").format(money);
    }

    public void makeChange(){
        Map<String,Integer> change =new LinkedHashMap<>();
        double changeAmount = this.getBalance();
        if (changeAmount > 0) {
            int quarters = (int) (changeAmount / QUARTER);
            changeAmount %= QUARTER;
            int dimes = (int) (changeAmount / DIME);
            changeAmount %= DIME;
            int nickels = (int) (changeAmount / NICKLE);
            changeAmount %= NICKLE;
            change.put("Quarters:", quarters);
            change.put("Dimes:", dimes);
            change.put("Nickels:", nickels);
        }
        printChange(change);
        this.balance = 0;
    }

    public void printChange(Map<String,Integer>change){
        System.out.println(System.lineSeparator() + "Dispensing Change");
        AsciiPrinter.printASCII("asciiface.txt", false);
        System.out.println("\n");
        for (SortedMap.Entry<String,Integer> entry: change.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
