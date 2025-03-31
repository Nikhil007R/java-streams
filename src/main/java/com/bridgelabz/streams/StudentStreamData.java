package com.bridgelabz.streams;

import java.io.*;

public class StudentStreamData {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        // Sample student data
        Student[] students = {
                new Student(91, "Akram", 7.8),
                new Student(92, "Zoya", 9.5),
                new Student(93, "Nikhil", 9.9)
        };

        // Write student data to binary file
        writeStudentData(students);

        // Read student data from binary file
        readStudentData();
    }

    // Method to write student details using DataOutputStream
    private static void writeStudentData(Student[] students) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Student s : students) {
                dos.writeInt(s.rollNumber);
                dos.writeUTF(s.name);
                dos.writeDouble(s.gpa);
            }
            System.out.println("Student data successfully written to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    // Method to read student details using DataInputStream
    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\n📌 Retrieving Student Data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}

// Student class to store details
class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

