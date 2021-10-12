package ex41;
import java.io.*;
import java.util.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class NameSorter {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        List<String> names = new ArrayList<String>();

        names = scanFile(file);

        // sort array list of names
        Collections.sort(names);

        write_into_file(names);
    }

    // read in file & put into an array list
    public static List<String> scanFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        List<String> names = new ArrayList<String>();

        while (input.hasNextLine())
        {
            names.add(input.nextLine());
        }

        return names;
    }

    // print sorted names into output file
    public static void write_into_file(List<String> names) throws IOException {
        FileWriter w_file = new FileWriter("src/main/java/ex41/exercise41_output.txt");
        PrintWriter print_line = new PrintWriter(w_file);

        print_line.println("Total of " + names.size() + " names");
        print_line.println("-----------------");

        for (int i = 0; i < names.size(); i++)
            print_line.println(names.get(i));

        print_line.close();
    }
}
