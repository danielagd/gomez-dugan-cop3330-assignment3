package ex43;
import java.io.*;
import java.util.Scanner;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class WebsiteGenerator {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Site name: ");
        String site_name = input.nextLine();

        System.out.print("Author: ");
        String author = input.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        String js = input.nextLine().toLowerCase();

        System.out.print("Do you want a folder for CSS? ");
        String css = input.nextLine().toLowerCase();

        String prompt = create_files(site_name, author, js, css);

        System.out.println(prompt);
    }

    // create desired files and directories based on inputs
    public static String create_files(String site_name, String author, String js, String css) throws IOException {
        String prompt = "";
        // Create Website directory
        String website = "src/main/java/ex43/website/";
        new File(website).mkdirs();

        // Create Site Name File
        String s_name = "src/main/java/ex43/website/" + site_name;
        new File(s_name).mkdirs();
        prompt += "Created ./website/" + site_name + "\n";

        String index_file = "src/main/java/ex43/website/"+site_name+"/index.html";
        prompt += make_file(index_file);
        write_into_html(index_file, site_name, author);

        if (js.equals("y") || js.equals("yes")){
            new File("src/main/java/ex43/website/"+site_name+"/js").mkdirs();
            prompt += "Created ./website/" + site_name +"/js\n";
        }

        if (css.equals("y") || css.equals("yes")){
            new File("src/main/java/ex43/website/"+site_name+"/css").mkdirs();
            prompt += "Created ./website/" + site_name +"/css\n";
        }
        return prompt;
    }

    // create a file in directory
    public static String make_file(String directory) throws IOException {
        File new_file = new File(directory);
        new_file.createNewFile();
        return "Created ." + directory.substring(18) + "\n";
    }

    // write desired code into index.html
    public static void write_into_html(String file, String site_name, String author) throws IOException {
        PrintWriter print_line = new PrintWriter(file);

        print_line.println("<!DOCTYPE html>");
        print_line.println("<html>");
        print_line.println("<head>");
        print_line.println("<title>"+site_name+"</title>");
        print_line.println("<meta name = \"author\" content = \"" + author + "\">");
        print_line.println("</head>");
        print_line.println("</html>");
        print_line.close();
    }
}
