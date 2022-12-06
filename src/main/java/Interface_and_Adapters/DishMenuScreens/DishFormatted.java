package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.DishMenu.DishPresenter;
import APP_Business_Rules.DishMenu.DishResponseModel;

/**
 * A dish formatter that implements the DishPresenter to present to the view.
 */
public class DishFormatted implements DishPresenter {

    /**
     * Implements the method prepareSuccessView from the interface, which prepares the model for the view to present
     * @param response: The given dish response model to present.
     * @return the response model for the view to present.
     */
    @Override
    public DishResponseModel prepareSuccessView(DishResponseModel response) {
        return response;
    }
}
