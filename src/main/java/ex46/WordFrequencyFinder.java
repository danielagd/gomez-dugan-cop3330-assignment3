package ex46;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class WordFrequencyFinder {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/ex46/exercise46_input.txt");

        List<String> list = new ArrayList<String>();

        list = parse_file(file);

        count_frequency(list);
    }

    // scan file into list of string
    public static List<String> parse_file(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        List<String> list = new ArrayList<String>();

        while (input.hasNext())
        {
            list.add(input.next());
        }

        return list;
    }

    // count frequency of a word in list and convert into hash map
    public static void count_frequency(List<String> list){
        Map<String, Integer> wordFreq = new TreeMap<>();
        Map<String, Integer> new_wordFreq = new TreeMap<>();
        String word_arr[] = list.toArray(new String[0]);

        for(int i = 0; i < word_arr.length; i++)
        {
            if (wordFreq.containsKey(word_arr[i]))
                wordFreq.put(word_arr[i], wordFreq.get(word_arr[i]) + 1);
            else
                wordFreq.put(word_arr[i], 1);
        }

        new_wordFreq = sortByValue(wordFreq);

        for (Map.Entry<String, Integer> x: new_wordFreq.entrySet()) {
            System.out.print(x.getKey() + ": ");
            for (int i = 0; i < x.getValue(); i++)
                System.out.print("*");
            System.out.println();
        }
    }

    // sort hash map and return sorted hash map
    public static HashMap<String, Integer> sortByValue(Map<String, Integer> old_list)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(old_list.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();

        for (Map.Entry<String, Integer> i: list)
        {
            temp.put(i.getKey(), i.getValue());
        }
        return temp;
    }
}
