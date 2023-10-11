package com.techelevator.customExceptions;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String errorMessage){
        super(errorMessage);
    }
}
