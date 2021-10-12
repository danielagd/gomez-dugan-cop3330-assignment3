package ex44;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Daniela Gomez-Dugan
 */
public class ProductSearchTest {

    @Test
    public void get_product() {
        List<Product> list = ProductSearch.get_product("src/main/java/ex44/exercise44_input.json");

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Widget", 25.0, 5));
        products.add(new Product("Thing", 15.0, 5));
        products.add(new Product("Doodad", 5.0, 10));

        assertEquals(true, list.size() == products.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(true, list.get(i).getName().equals((products.get(i).getName())));
            assertEquals(true, list.get(i).getPrice() == products.get(i).getPrice());
            assertEquals(true, list.get(i).getQuantity() == products.get(i).getQuantity());
        }
    }

    @Test
    public void search_for_products(){
        List<Product> list = ProductSearch.get_product("src/main/java/ex44/exercise44_input.json");

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Widget", 25.0, 5));
        products.add(new Product("Thing", 15.0, 5));
        products.add(new Product("Doodad", 5.0, 10));

        assertEquals(true, ProductSearch.search(list, "Widget"));
        assertEquals(true, ProductSearch.search(list, "Thing"));
        assertEquals(true, ProductSearch.search(list, "Doodad"));
        assertEquals(false, ProductSearch.search(list, "Yellow"));
    }

    @Test
    public void get_prompt()
    {
        List<Product> list = ProductSearch.get_product("src/main/java/ex44/exercise44_input.json");

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Widget", 25.0, 5));
        products.add(new Product("Thing", 15.0, 5));
        products.add(new Product("Doodad", 5.0, 10));

        assertEquals(true, "Name: Widget\nPrice: 25.0\nQuantity: 5".equals(ProductSearch.get_prompt(list, "Widget")));
        assertEquals(true, "Name: Doodad\nPrice: 5.0\nQuantity: 10".equals(ProductSearch.get_prompt(list, "Doodad")));
        assertEquals(true, "Name: Thing\nPrice: 15.0\nQuantity: 5".equals(ProductSearch.get_prompt(list, "Thing")));
    }

}
