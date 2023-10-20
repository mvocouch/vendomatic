package com.techelevator.mainClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    public void logDeposit(double amountDeposited, double newBalance, String timestamp) {
        String logFilePath = "Log.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            String depositInfo = timestamp + " FEED MONEY: $" + MoneyHandler.doubleToString(amountDeposited) + " $" + MoneyHandler.doubleToString(newBalance);

            // Write the deposit information to the log file
            writer.println(depositInfo);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log any file I/O errors
        }
    }
    public void logDeposit(double amountDeposited, double newBalance){
        // get current timestamp
        String timestamp = formatter.format(LocalDateTime.now());
        logDeposit(amountDeposited, newBalance, timestamp);
    }
    public void logPurchase(String locationSlot, String itemName, double itemCost, double remainingBalance,String timestamp) {
        String logFilePath = "Log.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            String purchaseInfo = timestamp + " " + locationSlot + " " + itemName + " $" + MoneyHandler.doubleToString(itemCost) + " $" + MoneyHandler.doubleToString(remainingBalance);

            // Write the purchase information to the log file
            writer.println(purchaseInfo);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log any file I/O errors
        }
    }
    public void logPurchase(String locationSlot, String itemName, double itemCost, double remainingBalance){
        String timestamp = formatter.format(LocalDateTime.now());
        logPurchase(locationSlot,itemName,itemCost,remainingBalance,timestamp);
    }
    public void logChangeGiven(double changeGiven, double remainingBalance, String timestamp){
        String logFilePath = "Log.txt";

        try(PrintWriter writer = new PrintWriter(new FileWriter(logFilePath,true))){
            String changeGivenInfo = timestamp + " GIVE CHANGE: $" + MoneyHandler.doubleToString(changeGiven) + " $" + MoneyHandler.doubleToString(remainingBalance);

            writer.println(changeGivenInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void logChangeGiven(double changeGiven, double remainingBalance){
        String timestamp = formatter.format(LocalDateTime.now());
        logChangeGiven(changeGiven,remainingBalance,timestamp);
    }
}
