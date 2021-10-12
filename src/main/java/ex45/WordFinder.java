package ex45;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class WordFinder {
    public static void main(String[] args) throws IOException {
        String file_dir = create_file();

        String file_contents = "";
        File file = new File("src/main/java/ex45/exercise45_input.txt");
        file_contents = scanFile(file);

        file_contents = replaceWord(file_contents);

        write_into_file(file_dir, file_contents);
    }

    // replace 'utilize' with 'use'
    public static String replaceWord(String str)
    {
        String new_string = "";
        new_string = str.replace("utilize", "use");
        return new_string;
    }

    // create output file
    public static String create_file() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String file_name = "src/main/java/ex45/" + input.nextLine();

        if (!file_name.substring(file_name.length() - 4).equals(".txt"))
            file_name += ".txt";

        File new_file = new File(file_name);
        new_file.createNewFile();
        return file_name;
    }

    // scan desired file into a string
    public static String scanFile(File file) throws FileNotFoundException
    {
        String file_contents = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                file_contents += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file_contents);
        return file_contents;
    }

    // write string into output file
    public static void write_into_file(String file, String file_contents) throws IOException {
        FileWriter w_file = new FileWriter(file);
        PrintWriter print_line = new PrintWriter(w_file);

        print_line.println(file_contents);

        print_line.close();
    }
}