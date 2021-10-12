package ex41;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class NameSorterTest {

    @Test
    public void scanFile() throws IOException {
        File file = new File("src/main/java/ex41/exercise41_input.txt");
        Scanner input = new Scanner(file);
        List<String> names = new ArrayList<String>();

        while (input.hasNextLine())
        {
            names.add(input.nextLine());
        }

        List<String> list = NameSorter.scanFile(file);

        assertEquals(names.size() == list.size(), true);

        for(int i = 0; i < names.size(); i++)
            assertEquals(names.get(i), list.get(i));
    }
}
