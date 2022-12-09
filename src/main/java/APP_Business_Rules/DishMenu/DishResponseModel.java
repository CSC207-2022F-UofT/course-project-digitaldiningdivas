package APP_Business_Rules.DishMenu;

/**
 * The response model for the dish facade implementation.
 */
public class DishResponseModel {
    String dish;

    /**
     * Contructor for the DishResponseModel.
     * @param dish: A string for the dish name that will be used for the dish of the model.
     */
    public DishResponseModel(String dish){
        this.dish = dish;
    }

    /**
     * Getter method for the dish attribute.
     * @return the String of the dish attribute.
     */
    public String getDish(){
        return dish;
    }

    /**
     * Setter method for the dish attribute.
     * @param dish: The dish string to be set by the method.
     */
    public void setDish(String dish) {
        this.dish = dish;
    }
}