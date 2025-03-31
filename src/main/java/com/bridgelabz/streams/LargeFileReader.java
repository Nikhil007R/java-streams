package com.bridgelabz.streams;

import java.io.*;

public class LargeFileReader {
    private static final String FILE_NAME = "FileInputFile.txt";

    public static void main(String[] args) {
        readLargeFile();
    }

    public static void readLargeFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive search
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

