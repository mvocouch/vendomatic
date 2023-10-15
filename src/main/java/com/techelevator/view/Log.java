package com.techelevator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.techelevator.view.MoneyHandler;

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
    public void logPurchase(String locationSlot, String itemName, double itemCost, double remainingBalance) {
        String logFilePath = "Log.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            // Get the current timestamp
            String timestamp = formatter.format(LocalDateTime.now());


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
            String timestamp = formatter.format(LocalDateTime.now());

            String changeGivenInfo = timestamp + " GIVE CHANGE: $" + MoneyHandler.doubleToString(changeGiven) + " $" + MoneyHandler.doubleToString(remainingBalance);

            writer.println(changeGivenInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
