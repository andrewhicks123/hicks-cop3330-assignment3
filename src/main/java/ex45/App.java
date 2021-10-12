/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Andrew Hicks
 */
/*
Ex45
Class App
    Main Method
        Open input file
        Scanner for file
        Scanner for user input
        Take input for output file name
        Create/open output file
        Loop to check each word
        Change each word as required
        Close file and filewriter
 */
package ex45;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        File file = new File("excercise45_input.txt");
        Scanner text = new Scanner(System.in);
        Scanner input = new Scanner(file);
        System.out.print("\nOutput file name: ");
        String output = text.next();
        FileWriter writer = new FileWriter(output + ".txt");
        try {
            while( input.hasNext() ) {
                String temp = input.nextLine();
                temp = temp.replaceAll("utilize", "use");
                writer.write(temp);
                writer.write("\n");
            }
        }finally {
            input.close();
        }
        writer.close();
    }

}
