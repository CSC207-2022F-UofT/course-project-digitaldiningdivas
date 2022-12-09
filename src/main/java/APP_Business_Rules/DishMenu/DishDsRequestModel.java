package APP_Business_Rules.DishMenu;

/**
 *Dish DsRequestModel Class
 */
public class DishDsRequestModel {
    private final String name;

    /**
     * Constructor that instantiates a DishDsRequestModel, an implementation of the facade design pattern.
     * @param name: The string of the dishes name
     */
    DishDsRequestModel(String name){
        this.name = name;
    }

    /**
     * A function that returns the name of the DishDsRequestModel.
     * @return: A string of the dishes name.
     */
    public String getName(){
        return name;
    }
}