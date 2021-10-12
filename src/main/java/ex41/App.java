/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Andrew Hicks
 */

/*
Ex41 - one class
•	Main Method
o	    Take input file
o	    Create array list
o	    readNames to array list
o	    Sort arraylist
o	    Close file
o	    outputNames with array list
•	outputNames(ArrayList<String> names)
o	    Create file
o	    Write the top of the file
o	    Output names
o	    Close file
•	readNames(Scanner input, ArrayList<String> list)
o	    Read names from input to arraylist

 */

package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class App {

    public static void readNames(Scanner input, ArrayList<String> list) {
        while (input.hasNextLine()) {
            list.add(input.nextLine());
        }
    }

    public static void outputNames(ArrayList<String> names) throws IOException {
        FileWriter output = new FileWriter("excercise41_output.txt");
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");
        for (String i : names) {
            output.write(i + "\n");
        }
        output.close();
    }

    static public void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("excercise41_input.txt"));
        ArrayList<String> list = new ArrayList<String>();
        readNames(inputFile, list);
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        inputFile.close();
        try {
            outputNames(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
