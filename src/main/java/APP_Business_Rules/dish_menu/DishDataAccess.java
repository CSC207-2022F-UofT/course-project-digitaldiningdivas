package APP_Business_Rules.dish_menu;

import java.util.HashMap;
import java.util.List;

/**
 * Dish Data Access interface
 */
public interface DishDataAccess {
    /**
     * Method checks if dish exists by the given name in the database
     * @param identifier: the string name that will be checked for matches in database
     * @return true iff string identifier is found.
     */
    boolean dishExistsByName(String identifier);

    /**
     * Gets the dishes from the database.
     * @param file: The chosen file to read from.
     * @return: Returns a hashmap of strings of restaurants, each restaurant containing dishes
     * represented as lists of strings.
     */
    HashMap<String, List<List<String>>> getDish(String file);
}