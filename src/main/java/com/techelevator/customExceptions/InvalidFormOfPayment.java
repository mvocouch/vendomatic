package com.techelevator.customExceptions;

public class InvalidFormOfPayment extends Exception{
    public InvalidFormOfPayment(String errorMessage){
        super(errorMessage);
    }
}
