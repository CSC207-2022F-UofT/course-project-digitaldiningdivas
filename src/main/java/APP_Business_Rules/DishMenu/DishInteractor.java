package APP_Business_Rules.DishMenu;

import Entities.Dish;

/**
 * The dish interactor class that implements DishInputBoundary to create response models.
 */
public class DishInteractor implements DishInputBoundary{

    final DishPresenter dishPresenter;
    final DishFactory dishFactory;
    final DishDataAccess gateway;

    /**
     * Instantiates a dish interactor with a gateway, presenter and factory.
     * @param gateway: The gateway to interact with the database.
     * @param dishPresenter: The presenter for the dish.
     * @param dishFactory: The factory to create dishes.
     */
    public DishInteractor(DishDataAccess gateway, DishPresenter dishPresenter, DishFactory dishFactory){

        this.dishPresenter = dishPresenter;
        this.dishFactory = dishFactory;
        this.gateway = gateway;
    }

    /**
     * The create method that instantiates a new dish model.
     * @param requestModel: the given request model
     * @return: A response model of the dish.
     */
    @Override
    public DishResponseModel create(DishRequestModel requestModel) {
        Dish dish = dishFactory.create(requestModel.getDishName(), requestModel.getDishCategory(),
                requestModel.getRestaurant(), requestModel.getDescription(), requestModel.getPrice());
        DishResponseModel dishResponseModel = new DishResponseModel(dish.getName());
        return dishPresenter.prepareSuccessView(dishResponseModel);
    }
}
