package com.techelevator.customExceptions;

public class OutOfStockException extends Exception{
    public OutOfStockException(String errorMessage){
        super(errorMessage);
    }
}
