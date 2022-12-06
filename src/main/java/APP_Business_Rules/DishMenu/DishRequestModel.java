package APP_Business_Rules.DishMenu;

/**
 * The request model for dishes, acts as a facade design pattern implementation to rely on an abstraction
 * model of a dish.
 */
public class DishRequestModel {
    private String DishName;
    private String DishCategory;
    private String restaurant;
    private String description;
    private double price;

    /**
     * A constructor for a DishRequestModel specifying the attributes of the dish model needed to be created.
     * @param DishName: The String name of the dish
     * @param DishCategory: The String of the dish's category (appetite, entree, etc.)
     * @param Restaurant: The String of the restaurant name the dish belongs to
     * @param Description: The String of the description of the dish.
     * @param price: A double of the price of the dish.
     */
    public DishRequestModel(String DishName, String DishCategory, String Restaurant, String Description, double price){
        this.DishName = DishName;
        this.DishCategory = DishCategory;
        this.restaurant = Restaurant;
        this.description = Description;
        this.price = price;

    }

    /**
     * Getter method for the dish category.
     * @return: A string of the dish category
     */
    public String getDishCategory(){
        return DishCategory;
    }

    /**
     * Getter method for the Dish name
     * @return: A string of the dish name.
     */
    public String getDishName(){
        return DishName;
    }

    /**
     * Getter method for the restaurant the dish belongs to.
     * @return: A string of the restaurants name the dish belongs to.
     */
    public String getRestaurant(){
        return restaurant;
    }

    /**
     * Getter method for the string description of the dish.
     * @return: The string description of the restaurant.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Getter method for the price of the dish
     * @return the double of the price of the object.
     */
    public double getPrice(){
        return price;
    }
}
