/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Andrew Hicks
 */

/*
Class App
    Main Method
        Scanner input
        Create string variables
        Default js and css to N
        Take inputs

        Path Function
        HTML Function
        JS Function
        CSS Function


Class Functions
    html(path)
        Create HTML file
        Write all necessary lines to the file
        Close file
    js(a,path)
        Check if A is true
        If A is true, create JS file at path
    css(a,path)
        Check if A is true
        If A is true, create CSS file at path
    setpath(name)
        Get current directory
        Return path with name
 */
package ex43;
import java.util.*;
import java.io.*;


public class App {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String path = null, author, name;
        char js = 'N';
        char css = 'N';

        System.out.print("Site name: ");
        name = input.nextLine();
        System.out.print("Author: ");
        author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        js = input.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css = input.next().charAt(0);


        path = Functions.setPath(name);
        Functions.makeDir(path);
        Functions.html(path,author,name);
        Functions.js(js,path);
        Functions.css(css,path);

    }
}

class Functions{
    static String setPath(String name){
        String path;
        path = System.getProperty("user.dir");
        path += "\\"+name;
        return path;
    }
    static void makeDir(String path){
        File site = new File(path);
        boolean success = site.mkdir();
        if(success){
            System.out.println("Created "+path);
        }
    }
    static void html(String path,String author, String name) throws IOException {
        FileWriter index = new FileWriter(new File(path+"\\index.html"));
        index.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
        index.write("\t<meta author=\""+author+"\">\n");
        index.write("\t<title>"+name+"</title>\n");
        index.write("</head>\n<body>\n\n</body>\n</html>");
        index.close();
        System.out.println("Created " + path+"\\index.html");
    }
    static void css(char a,String path){
        if(a == 'y' || a == 'Y') {
            File cssFolder = new File(path + "\\css");
            boolean cssCreated = cssFolder.mkdir();
            if (cssCreated) {
                System.out.println("Created " + cssFolder + "\\");
            }else{
                System.out.println("CSS folder failed");
            }
        }
    }
    static void js(char a,String path){
        if(a == 'y' || a == 'Y') {
            File jsFolder = new File(path + "\\js");
            boolean jsCreated = jsFolder.mkdir();
            if (jsCreated) {
                System.out.println("Created " + jsFolder + "\\");
            }else{
                System.out.println("JJ folder failed");
            }
        }
    }
}
