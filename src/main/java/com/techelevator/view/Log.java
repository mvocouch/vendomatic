package com.techelevator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import com.techelevator.view.MoneyHandler;

public class Log {

    public void logDeposit(double amountDeposited, double newBalance) {
        String logFilePath = "Log.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            // Get the current timestamp
            LocalDateTime timestamp = LocalDateTime.now();

            // Format the deposit information
            String depositInfo = timestamp + " FEED MONEY: $" + MoneyHandler.doubleToString(amountDeposited) + " $" + MoneyHandler.doubleToString(newBalance);

            // Write the deposit information to the log file
            writer.println(depositInfo);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log any file I/O errors
        }
    }

    public void logPurchase(String locationSlot, String itemName, double itemCost, double remainingBalance) {
        String logFilePath = "Log.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            // Get the current timestamp
            LocalDateTime timestamp = LocalDateTime.now();

            // Format the purchase information
            String purchaseInfo = timestamp + " " + locationSlot + " " + itemName + " $" + MoneyHandler.doubleToString(itemCost) + " $" + MoneyHandler.doubleToString(remainingBalance);

            // Write the purchase information to the log file
            writer.println(purchaseInfo);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log any file I/O errors
        }
    }
    public void logChangeGiven(double changeGiven, double remainingBalance){
        String logFilePath = "Log.txt";

        try(PrintWriter writer = new PrintWriter(new FileWriter(logFilePath,true))){
            LocalDateTime timeStamp = LocalDateTime.now();

            String changeGivenInfo = timeStamp + " GIVE CHANGE: $" + MoneyHandler.doubleToString(changeGiven) + " $" + MoneyHandler.doubleToString(remainingBalance);

            writer.println(changeGivenInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
