package interface_and_adapters;

import APP_Business_Rules.restaurant_use_case.RestaurantInputBoundary;
import APP_Business_Rules.restaurant_use_case.RestaurantRequestModel;
import APP_Business_Rules.restaurant_use_case.RestaurantResponseModel;

public class RestaurantController {
    /* Retrieves user Input from Restaurant View and passes it to the Interactor to modify Restaurant
    private final RestaurantInputBoundary
     */
    private final RestaurantInputBoundary userInput;
    public RestaurantController(RestaurantInputBoundary restaurantGateway){
        this.userInput = restaurantGateway;
    }
    RestaurantResponseModel create(RestaurantRequestModel requestModel){
        return userInput.create(requestModel);
    }
}
