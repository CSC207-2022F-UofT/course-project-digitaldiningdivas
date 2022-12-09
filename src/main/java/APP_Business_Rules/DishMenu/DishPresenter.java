package APP_Business_Rules.DishMenu;

/**
 * The presenter interface for dishes.
 */
public interface DishPresenter {
    /**
     * Prepares the success view for the view/UI.
     * @param responseModel: The given dish response model to present.
     * @return: returns the response model given to the view.
     */
    DishResponseModel prepareSuccessView(DishResponseModel responseModel);
}