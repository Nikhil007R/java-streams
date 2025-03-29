package com.bridgelabz.streams;
import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("fileInput.txt");
            FileOutputStream fos = new FileOutputStream("fileOutput.txt");

            int byteData;
            while ((byteData = fis.read()) != -1) {
                 fos.write(byteData);
//                System.out.print(byteData);
            }
            System.out.println("\nFile copied successfully: ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block executing. ");
        }
    }
}
