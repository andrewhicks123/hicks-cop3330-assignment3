/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Andrew Hicks
 */

/*
Ex46
Class App
    Main Method
        Create Map
        buildMap function
        printOutput function

Class Functions
    buildMap(Map)
        Loop for every word in file
        Each word, add to map

    printOutput(Map)
        Print word
        Print * for word quantity
 */

package ex46;

import java.io.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {

    public static void main(String args[]) throws IOException {
        Map<String,Integer> maps=new TreeMap<String,Integer>();
        Printers.buildMap(maps);
        Printers.printOutput(maps);
    }
}

class Printers{
    static void printOutput(Map<String,Integer> maps){
        for( String key : maps.keySet() ) {
            System.out.printf("%-10s", key + ":");
            for(int i = maps.get(key); i>0; i--)
                System.out.print("*");
            System.out.println();
        }
    }
    static void buildMap(Map<String,Integer> maps) throws FileNotFoundException {
        Scanner file=new Scanner(new File("exercise46_input.txt"));
        while( file.hasNext() ) {
            String string = file.next();
            if(maps.containsKey(string))
                maps.put(string, maps.get(string)+1);
            else
                maps.put(string, 1);
        }
    }
}

