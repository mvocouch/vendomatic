package com.techelevator;

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
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMoneyReturned() {
        return moneyReturned;
    }
    public void setMoneyReturned(double moneyReturned) {
        this.moneyReturned = moneyReturned;
    }
    public void addToBalance(int dollars){
        this.balance += dollars;
    }
    public String doubleToString(double money){
        return new DecimalFormat("0.00").format(money);
    }

    public void transaction(){

    }


}
