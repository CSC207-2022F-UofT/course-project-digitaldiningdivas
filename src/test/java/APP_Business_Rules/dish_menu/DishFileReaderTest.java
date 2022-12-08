package APP_Business_Rules.dish_menu;

import APP_Business_Rules.DishMenu.DishFileReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DishFileReaderTest {

    @Test
    public void readerTest() {
        List<List<String>> expected_output = new ArrayList<>();
        List<String> dish1 = new ArrayList<>();
        dish1.add("Chilled Lobster");
        dish1.add("9");
        dish1.add("Gem lettuce with lime aioli");
        dish1.add("Entree");
        dish1.add("40.00");
        List<String> dish2 = new ArrayList<>();
        dish2.add("East Coast Oysters");
        dish2.add("8");
        dish2.add("Citrus and tobasco");
        dish2.add("Entree");
        dish2.add("26.00");
        expected_output.add(dish2);
        expected_output.add(dish1);

        DishFileReader dishReader = new DishFileReader("./dishes.csv");
        HashMap<String, List<List<String>>> actual_output = dishReader.createList();
        assert (expected_output.equals(actual_output.get("Alobar")));
    }
}
