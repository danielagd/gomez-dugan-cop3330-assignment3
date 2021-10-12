package ex45;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class WordFinderTest {

    @Test
    public void replaceWord()
    {
        String old_str = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "utilizes an IDE to write her Java programs\".\n";
        String new_str = "One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
            "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
            "uses an IDE to write her Java programs\".\n";
        assertEquals(new_str, WordFinder.replaceWord(old_str));
    }

    @Test
    public void scanFile() throws FileNotFoundException {
        String str = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "utilizes an IDE to write her Java programs\".\n`";
        File input_file = new File("src/main/java/ex45/exercise45_input.txt");
        assertEquals(str, WordFinder.scanFile(input_file));
    }
}
