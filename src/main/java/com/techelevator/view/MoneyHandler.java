package com.techelevator.view;

import com.techelevator.customExceptions.InsufficientBalanceException;
import com.techelevator.customExceptions.InvalidFormOfPayment;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

public class MoneyHandler {
    private double balance;
    public MoneyHandler() {
        this.balance = 0;

    }
    public double getBalance() {
        return balance;
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

    public void makeChange() {
        Map<String, BigDecimal> change = new LinkedHashMap<>();
        BigDecimal changeAmount = BigDecimal.valueOf(this.getBalance());

        BigDecimal QUARTER = new BigDecimal("0.25");
        BigDecimal DIME = new BigDecimal("0.10");
        BigDecimal NICKLE = new BigDecimal("0.05");

        BigDecimal quarters = changeAmount.divide(QUARTER, 0, BigDecimal.ROUND_DOWN);
        changeAmount = changeAmount.remainder(QUARTER);
        BigDecimal dimes = changeAmount.divide(DIME, 0, BigDecimal.ROUND_DOWN);
        changeAmount = changeAmount.remainder(DIME);
        BigDecimal nickels = changeAmount.divide(NICKLE, 0, BigDecimal.ROUND_DOWN);

        change.put("Quarters:", quarters);
        change.put("Dimes:", dimes);
        change.put("Nickels:", nickels);

        printChange(change);
        this.balance = 0;
    }
    public void printChange(Map<String,BigDecimal>change){
        System.out.println(System.lineSeparator() + "Dispensing Change");
        AsciiPrinter.printASCII("asciiface.txt", false);
        System.out.println("");
        for (SortedMap.Entry<String,BigDecimal> entry: change.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
