package APP_Business_Rules.dish_menu;

import entities.Dish;

/**
 * A Dish factory, which instantiates a dish as this implements the factory design pattern.
 */
public class DishFactory {

    /**
     * An instantiation of a dish is created by the factory.
     * @param DishName: A string of the name of the dish created.
     * @param DishCategory: A string of the category of the dish created (appetizer, entree, etc.)
     * @param Restaurant: The string name of the restaurant the dish belongs to.
     * @param Description: A string of the description of the dish.
     * @param price: The price in a double of the dish.
     * @return returns a dish object with the given attributes
     */
    public Dish create(String DishName, String DishCategory, String Restaurant, String Description, double price){
        return new Dish(DishName, DishCategory, Restaurant, Description, price);
    }
}