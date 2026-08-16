package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parsing {
    private static final Scanner scannerObj = new Scanner(System.in);
    private static final StringBuilder jsonInput = new StringBuilder();
    private static String currentLine;

    public static String chooseInput() {
        System.out.println("Please input 1 for file input, and 2 for inline input: (note any other input will close the program)");
        int choice = scannerObj.nextInt();
        if(choice==1) {
            return jsonThroughFile("src/main/java/org/example/data/input.json");
        } else if (choice==2) {
            return jsonThroughInput();}

        System.out.println("Goodbye");
        System.exit(0);

        return null;
    }

    public static String jsonThroughFile(String filePath) {
        File inputFile = new File(filePath);
        try (Scanner reader = new Scanner(inputFile)) {
            while (reader.hasNextLine()) {
                currentLine = reader.nextLine();
                jsonInput.append(currentLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File location not found.",e);
        }

        return jsonInput.toString();
    }
    public static String jsonThroughInput() {
        System.out.println("Enter input: (note that the input stream will end when an enclosing square bracket is presented ']')");

        while (scannerObj.hasNextLine()){
            currentLine = scannerObj.nextLine();
            jsonInput.append(currentLine);
            if(currentLine.contains("]")) break;
        }

        return jsonInput.toString();
    }
}
