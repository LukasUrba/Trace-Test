package org.example;

import java.util.Scanner;

public class Parsing {
    private static final Scanner scannerObj = new Scanner(System.in);

    public static String chooseInput() {
        System.out.println("Please input 1 for file input, and 2 for inline input: (note any other input will close the program)");
        int choice = scannerObj.nextInt();
        if(choice==1) {
            return jsonThroughFile();
        } else if (choice==2) {
            return jsonThroughInput();
        }
        System.out.println("Goodbye");
        System.exit(0);
        return null;
    }
//TODO make input from file choice

    public static String jsonThroughFile() {
        return "hi";
    }
    public static String jsonThroughInput() {

        StringBuilder jsonInput = new StringBuilder();
        String currentLine;

        System.out.println("Enter input: (note that the input stream will end when an enclosing square bracket is presented ']')");

        while (scannerObj.hasNextLine()){
            currentLine = scannerObj.nextLine();
            jsonInput.append(currentLine);
            if(currentLine.contains("]")) break;
        }

        return jsonInput.toString();

    }

}
