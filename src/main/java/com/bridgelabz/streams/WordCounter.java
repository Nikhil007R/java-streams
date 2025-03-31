package com.bridgelabz.streams;

import java.io.*;
import java.util.*;

public class WordCounter {
    private static final String FILE_NAME = "FileInputFile.txt"; // Change this to your file

    public static void main(String[] args) {
        countWords();
    }

    public static void countWords() {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split on non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display total word count
        System.out.println("Total Words: " + wordCount.size());

        // Display the top 5 most frequent words
        System.out.println("\n Top 5 Most Frequent Words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

