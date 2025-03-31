package com.bridgelabz.streams;

import java.io.*;
import java.nio.file.Files;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImagePath = "inputImage.png";
        String outputImagePath = "outputImage.png";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(sourceImagePath);
            System.out.println("Image successfully converted to byte array!");

            // Convert byte array back to image
            writeByteArrayToImage(imageBytes, outputImagePath);
            System.out.println("New image successfully created!");

            // Verify if the files are identical
            if (areFilesIdentical(sourceImagePath, outputImagePath)) {
                System.out.println("The new image is identical to the original.");
            } else {
                System.out.println("The new image is different from the original.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Convert image file to byte array
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Convert byte array back to image file
    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Compare original and copied files
    private static boolean areFilesIdentical(String file1, String file2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(file1).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(file2).toPath());
        return java.util.Arrays.equals(file1Bytes, file2Bytes);
    }
}

