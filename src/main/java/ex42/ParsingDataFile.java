package ex42;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class ParsingDataFile {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/ex42/exercise42_input.txt");

        List<String[]> data = new ArrayList<String[]>();

        data = scanFile(file);

        print_table(data);
    }

    // read in file & put into an array list
    public static List<String[]> scanFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        List<String[]> data = new ArrayList<String[]>();

        while (input.hasNextLine())
        {
            String str = input.nextLine();
            String[] information = str.split(",", 3);
            data.add(information);
        }

        return data;
    }

    // Print table
    public static void print_table(List<String[]> data) throws IOException {
        System.out.printf("%-10s %-10s %-10s\n", "Last", "First", "Salary");
        System.out.println("--------------------------");

        for (int i = 0; i < data.size(); i++)
            System.out.printf("%-10s %-10s %-10s\n", data.get(i)[0],data.get(i)[1], data.get(i)[2]);
    }
}
