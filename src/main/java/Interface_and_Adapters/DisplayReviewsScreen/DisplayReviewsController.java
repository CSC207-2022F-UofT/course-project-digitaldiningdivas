package Interface_and_Adapters.DisplayReviewsScreen;

import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInputBoundary;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsRequestModel;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsResponseModel;

public class DisplayReviewsController {

    final DisplayReviewsInputBoundary userInput;

    public DisplayReviewsController(DisplayReviewsInputBoundary reviewsGateway){
        this.userInput = reviewsGateway;
    }

    public DisplayReviewsResponseModel create(Object reviewed){
        DisplayReviewsRequestModel requestModel = new DisplayReviewsRequestModel(reviewed);

        return userInput.create(requestModel);
    }
}
