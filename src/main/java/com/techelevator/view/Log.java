package com.techelevator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Log {
    public  void logPurchase(String slotLocation, String itemName, double itemCost) {
        String logFilePath = "Log.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            // Get the current timestamp
            LocalDateTime timestamp = LocalDateTime.now();

            // Format the purchase information
            String purchaseInfo =  timestamp + slotLocation + itemName + itemCost;

            // Write the purchase information to the log file
            writer.println(purchaseInfo);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log any file I/O errors
        }
    }
}
