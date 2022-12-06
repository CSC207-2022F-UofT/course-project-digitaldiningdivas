package interface_and_adapters.dish_menu_screens;


import APP_Business_Rules.dish_menu.DishInputBoundary;
import APP_Business_Rules.dish_menu.DishRequestModel;
import APP_Business_Rules.dish_menu.DishResponseModel;

/**
 *The dish controller class.
 */
public class DishController {

    private final DishInputBoundary userInput;

    /**
     * Constructor for the controller object.
     * @param dishGateway: the given gateway for the controller.
     */
    public DishController(DishInputBoundary dishGateway){
        this.userInput = dishGateway;
    }

    /**
     * Creating a DishResponseModel for the dish
     * @param requestModel: The given DishRequestModel for the response model
     * @return a DishResponseModel based on the given requestModel.
     */
    DishResponseModel create(DishRequestModel requestModel){
        return userInput.create(requestModel);
    }
}