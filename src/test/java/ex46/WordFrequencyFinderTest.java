package ex46;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class WordFrequencyFinderTest {

    @Test
    public void scanFile() throws FileNotFoundException {
        File file = new File("src/main/java/ex46/exercise46_input.txt");
        Scanner input = new Scanner(file);
        List<String> list = new ArrayList<String>();

        while (input.hasNext())
        {
            list.add(input.next());
        }

        List<String> words = WordFrequencyFinder.parse_file(file);

        assertEquals(true, words.size() == list.size());

        for (int i = 0; i < list.size(); i++)
            assertEquals(words.get(i), list.get(i));
    }

    @Test
    public void sortByValue() {
        HashMap<String, Integer> unsorted_map = new HashMap<>();
        unsorted_map.put("badger", 7);
        unsorted_map.put("mushroom", 8);
        unsorted_map.put("snake", 1);

        HashMap<String, Integer> sorted_map = new HashMap<>();
        unsorted_map.put("mushroom", 8);
        unsorted_map.put("badger", 7);
        unsorted_map.put("snake", 1);

        for (int i = 0; i < 3; i++)
        {
            assertEquals(true, unsorted_map.get(i) == sorted_map.get(i));
        }
    }
}
