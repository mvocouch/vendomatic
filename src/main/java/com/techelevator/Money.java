package com.techelevator;

public class Money {
    private double moneyProvided;
    private double moneyReturned;

    private static final double ONE_DOLLAR = 1.00;
    private static final double FIVE_DOLLAR = 5.00;
    private static final double TEN_DOLLAR = 10.00;
    private static final double QUARTER = 0.25;
    private static final double DIME = 0.10;
    private static final double NICKLE = 0.05;
    private static final double PENNY = 0.01;

    public Money(double moneyProvided) {
        this.moneyProvided = 0;

    }

    public double getMoneyProvided() {
        return moneyProvided;
    }
    public void setMoneyProvided(double moneyProvided) {
        this.moneyProvided = moneyProvided;
    }

    public double getMoneyReturned() {
        return moneyReturned;
    }
    public void setMoneyReturned(double moneyReturned) {
        this.moneyReturned = moneyReturned;
    }
    public void feedMoney(int dollars){
        this.moneyProvided += dollars;
    }

    public void transaction(){

    }


}
