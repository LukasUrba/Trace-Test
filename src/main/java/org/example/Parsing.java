package org.example;

import java.util.Scanner;

public class Parsing {
    private static final Scanner scannerObj = new Scanner(System.in);

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
