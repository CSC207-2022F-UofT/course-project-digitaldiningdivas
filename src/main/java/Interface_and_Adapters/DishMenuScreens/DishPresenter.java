package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.DishMenu.DishResponseModel;
import APP_Business_Rules.RestaurantUseCase.RestaurantResponseModel;

public interface DishPresenter {
    public DishResponseModel prepareSuccessView(DishResponseModel responseModel);
}
