package Interface_and_Adapters.DishMenuScreens;


import APP_Business_Rules.DishMenu.DishInputBoundary;
import APP_Business_Rules.DishMenu.DishRequestModel;
import APP_Business_Rules.DishMenu.DishResponseModel;

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