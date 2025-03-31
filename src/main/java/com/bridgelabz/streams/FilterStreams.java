package com.bridgelabz.streams;

import java.io.*;

public class FilterStreams {
    public static void main(String[] args) {
        String inputFile = "UpperCase.txt";   // Source file
        String outputFile = "LowerCase.txt"; // Destination file

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert to lowercase
                writer.newLine();  // Preserve line breaks
            }
            System.out.println("File conversion completed.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
