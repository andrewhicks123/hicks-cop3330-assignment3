/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Andrew Hicks
 */

/*
Ex42 - one class
•	Main Method
o	    Take input file
o	    Create array list
o	    readNames to array list
o	    Close file
o	    outputNames with array list
•	readNames(Scanner input, ArrayList<String> list)
o	    Read names from input file to arraylist
•	outputNames(ArrayList<String> list)
o	    Create output file
o	    Write the top of the  file
o	    Loop to write all names with formatting
 */

package ex42;

import java.io.*;
import java.util.*;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("excercise42_input.txt"));
        ArrayList<String> list = new ArrayList<String>();
        readNames(inputFile, list);
        inputFile.close();
        try {
            outputNames(list);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void readNames(Scanner input, ArrayList<String> list) {
        while (input.hasNextLine()) {
            list.add(input.nextLine());
        }
    }
    public static void outputNames(ArrayList<String> list) throws IOException {
        FileWriter output = new FileWriter("excercise42_output.txt");
        output.write(String.format("%-14s%-14s%-14s\n", "First", "Last", "Salary"));
        output.write("----------------------------------\n");
        for(int i = 0; i < list.size(); i++){
            String[] temp = list.get(i).split(",");
            output.write(String.format("%-14s%-14s%-14s\n", temp[0], temp[1], temp[2]));
        }
        output.close();
    }
}
