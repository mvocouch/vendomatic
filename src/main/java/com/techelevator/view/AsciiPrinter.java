package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiPrinter {
    public static void printASCII(String asciiFilePath){
        File asciiFile =  new File(asciiFilePath);
        try (Scanner scanner = new Scanner(asciiFile)){
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e){
            //Do nothing
        }
    }
}