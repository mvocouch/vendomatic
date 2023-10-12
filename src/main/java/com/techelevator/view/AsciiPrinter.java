package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiPrinter {
    public static void printASCII(String asciiFilePath, boolean multiline){
        File asciiFile =  new File(asciiFilePath);
        try (Scanner scanner = new Scanner(asciiFile)){
            while (scanner.hasNextLine()){
                if (multiline){
                    System.out.println(scanner.nextLine());
                } else {
                    System.out.print(scanner.nextLine());
                }
            }
        } catch (FileNotFoundException e){
            //Do nothing
        }
    }
    public static void printASCII(String asciiFilePath){
        printASCII(asciiFilePath, true);
    }
}