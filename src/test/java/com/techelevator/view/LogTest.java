package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LogTest {
    private Log log;
    private File file;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");

    @Before
    public void setUp() {
        log = new Log();
        file = new File("Log.txt");
    }

    @Test
    public void testLogDeposit() {
        String dateAndTime = formatter.format(LocalDateTime.now());
        log.logDeposit(10, 20, dateAndTime);
        String lastLine = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lastLine = scanner.nextLine();
            }
            Assert.assertEquals(dateAndTime + " FEED MONEY: $10.00 $20.00", lastLine);
        } catch (FileNotFoundException e) {
            System.err.println("File not found when test attempted.");
        }


    }

    @Test
    public void testLogPurchase() {
        String dateAndTime = formatter.format(LocalDateTime.now());
        log.logPurchase("Z12","Ramen", 100, 4);
        String lastLine = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lastLine = scanner.nextLine();
            }
            Assert.assertEquals(dateAndTime + " Z12 Ramen $100.00 $4.00", lastLine);
        } catch (FileNotFoundException e) {
            System.err.println("File not found when test attempted.");
        }

    }
    @Test
    public void testChangeGiven() {
        String dateAndTime = formatter.format(LocalDateTime.now());
        log.logChangeGiven(10, 0);
        String lastLine = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lastLine = scanner.nextLine();
            }
            Assert.assertEquals(dateAndTime + " GIVE CHANGE: $10.00 $0.00", lastLine);
        } catch (FileNotFoundException e) {
            System.err.println("File not found when test attempted.");
        }


    }
}