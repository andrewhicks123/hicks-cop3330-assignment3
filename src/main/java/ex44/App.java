/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Andrew Hicks
 */
/*
Ex44

Class App
    Main Method
        Create JSON Parser
        Open file with parser
        Get products from file
        While Loop
            Get inputs from user
            Check inputs against the JSON
            If match, display it and end
            If not match, get input again
Class Functions
    checkFlag(int a)
        check if a is 0, if yes print not found
 */

package ex44;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.*;
import java.util.Iterator;

class Functions{
    static boolean checkFlag(int a){
        if(a==0){
            System.out.println("Sorry, that product was not found in our inventory");
            return false;
        }
        return true;
    }
}
public class App {
    public static void main(String[] args){
        JSONParser parser = new JSONParser();
        try{
            Object json = parser.parse(new FileReader("excercise44_input.json"));
            JSONObject jsonObject = (JSONObject) json;
            JSONArray subjects = (JSONArray) jsonObject.get("products");
            String in;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int flag = 0;
            while (flag == 0){
                System.out.print("What is the product name? ");
                Iterator ite = subjects.iterator();
                in = reader.readLine();
                while (ite.hasNext()) {
                    JSONObject current = (JSONObject) ite.next();
                    String name = (String) current.get("name");
                    if (in.equalsIgnoreCase(name)) {
                        System.out.println("Name: " + name);
                        System.out.println("Price: " + current.get("price"));
                        System.out.println("Quantity: " + current.get("quantity"));
                        flag = 1;
                    }
                }
                boolean testing = Functions.checkFlag(flag);
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}
