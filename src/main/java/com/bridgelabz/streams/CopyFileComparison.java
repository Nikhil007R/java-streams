package com.bridgelabz.streams;

import java.io.*;

public class CopyFileComparison {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String sourceFile = "source_file.txt";
        String destBuffered = "BufferedFile.txt";
        String destUnbuffered = "FileInputFile.txt";

        System.out.println("Copying file using Buffered Streams...");
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);
        System.out.println("Time taken with Buffered Streams: " + bufferedTime + " ns\n");

        System.out.println("Copying file using Unbuffered Streams...");
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Time taken with Unbuffered Streams: " + unbufferedTime + " ns");

        System.out.println("\nPerformance Improvement: " + (double) unbufferedTime / bufferedTime + "x faster using Buffered Streams.");
    }

    // Buffered Stream Copy
    private static long copyUsingBufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    // Unbuffered Stream Copy
    private static long copyUsingUnbufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}

