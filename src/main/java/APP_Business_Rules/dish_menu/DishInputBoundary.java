package APP_Business_Rules.dish_menu;

/**
 * An interface for dish input boundary.
 */
public interface DishInputBoundary {

    /**
     * Creates a dish response model.
     * @param requestModel: the given request model
     * @return a response model of the dish.
     */
    DishResponseModel create(DishRequestModel requestModel);
}
