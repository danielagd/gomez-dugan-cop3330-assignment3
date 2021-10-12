package ex44;
import com.google.gson.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class ProductSearch {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        List<Product> products = get_product("src/main/java/ex44/exercise44_input.json");
        String name = search_for_products(products);
        String prompt = get_prompt(products, name);
        System.out.println(prompt);
    }

    // read json file and make into a list of products
    public static List<Product> get_product(String file_dir)
    {
        File file = new File(file_dir);
        List<Product> products = new ArrayList<Product>();

        try {
            JsonElement file_element = JsonParser.parseReader(new FileReader(file));
            JsonObject file_object = file_element.getAsJsonObject();
            JsonArray json_array_products = file_object.get("products").getAsJsonArray();

            for (JsonElement product: json_array_products)
            {
                JsonObject product_json_obj = product.getAsJsonObject();
                String name = product_json_obj.get("name").getAsString();
                double price = product_json_obj.get("price").getAsDouble();
                Integer quantity = product_json_obj.get("quantity").getAsInt();

                Product new_product = new Product(name, price, quantity);
                products.add(new_product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    // prompt question until it is found in list
    public static String search_for_products(List<Product> list)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("What is the product name? ");
        String product_name = input.nextLine();

        while (!search(list, product_name))
        {
            System.out.println("Sorry, that product was not found in our inventory.");
            System.out.println("What is the product name? ");
            product_name = input.nextLine();
        }

        return product_name;
    }

    // return true if string is in list, return false otherwise
    public static boolean search(List<Product> list, String product_name)
    {
        for (Product x:list)
        {
            if (x.getName().equals(product_name))
                return true;
        }
        return false;
    }

    // construct the print statement desired
    public static String get_prompt(List<Product> list, String product_name)
    {
        String name = product_name;
        double price = 0.0;
        Integer quantity = 0;

        for (Product x:list)
        {
            if (x.getName().equals(product_name))
            {
                price = x.getPrice();
                quantity = x.getQuantity();
                break;
            }
        }

        String prompt = "Name: " + name + "\nPrice: " + price + "\nQuantity: " + quantity;
        return prompt;
    }

}

// product object
class Product {
    public String name;
    public double price;
    public Integer quantity;

    public Product(){}

    public Product(String name, double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
}

