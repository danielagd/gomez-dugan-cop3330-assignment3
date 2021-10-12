package ex43;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class WebsiteGeneratorTest {

    @Test
    public void create_files() throws IOException {
        String prompt = WebsiteGenerator.create_files("awesome", "daniela", "y", "y");

        File website_dir = new File("src/main/java/ex43/website");
        assertEquals(true, website_dir.exists());

        File site_dir = new File("src/main/java/ex43/website/awesome");
        assertEquals(true, site_dir.exists());

        File index_file = new File("src/main/java/ex43/website/awesome/index.html");
        assertEquals(true, index_file.exists());

        File js_dir = new File("src/main/java/ex43/website/awesome/js");
        assertEquals(true, js_dir.exists());

        File css_dir = new File("src/main/java/ex43/website/awesome/css");
        assertEquals(true, css_dir.exists());

        assertEquals(prompt, "Created ./website/awesome\nCreated ./website/awesome/index.html\nCreated ./website/awesome/js\nCreated ./website/awesome/css\n");
    }

    @Test
    public void create_files2() throws IOException {
        String prompt = WebsiteGenerator.create_files("awesome2", "daniela", "n", "n");

        File website_dir = new File("src/main/java/ex43/website");
        assertEquals(true, website_dir.exists());

        File site_dir = new File("src/main/java/ex43/website/awesome2");
        assertEquals(true, site_dir.exists());

        File index_file = new File("src/main/java/ex43/website/awesome2/index.html");
        assertEquals(true, index_file.exists());

        File js_dir = new File("src/main/java/ex43/website/awesome2/js");
        assertEquals(false, js_dir.exists());

        File css_dir = new File("src/main/java/ex43/website/awesome2/css");
        assertEquals(false, css_dir.exists());

        assertEquals(prompt, "Created ./website/awesome2\nCreated ./website/awesome2/index.html\n");
    }
}
