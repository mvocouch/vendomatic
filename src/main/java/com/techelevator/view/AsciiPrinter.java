package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiPrinter {
    public static void printASCII(){
        File asciiFile =  new File("asciitext.txt");
        try (Scanner scanner = new Scanner(asciiFile)){
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e){
            //Do nothing
        }
    }
}