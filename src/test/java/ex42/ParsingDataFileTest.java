package ex42;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class ParsingDataFileTest {

    @Test
    public void scanFile() throws FileNotFoundException {
        File file = new File("src/main/java/ex42/exercise42_input.txt");
        Scanner input = new Scanner(file);
        List<String[]> data = new ArrayList<String[]>();

        while (input.hasNextLine())
        {
            String str = input.nextLine();
            String[] information = str.split(",", 3);
            data.add(information);
        }

        List<String[]> expected = ParsingDataFile.scanFile(file);

        assertEquals(true, data.size() == expected.size());

        for(int i = 0; i < data.size(); i++)
            for (int k = 0; k < 3; k++)
                assertEquals(data.get(i)[k], expected.get(i)[k]);

    }
}
