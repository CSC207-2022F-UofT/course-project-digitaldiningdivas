package APP_Business_Rules.restaurant_use_case;

import entities.Restaurant;
import interface_and_adapters.RestaurantPresenter;

public class RestaurantInteractor implements RestaurantInputBoundary{
    final RestaurantPresenter restaurantPresenter;
    final RestaurantFactory restaurantFactory;
    final RestaurantDataAccess gateway;

    public RestaurantInteractor(RestaurantDataAccess gateway, RestaurantPresenter restaurantPresenter, RestaurantFactory restaurantFactory
    ){

        this.restaurantPresenter = restaurantPresenter;
        this.restaurantFactory = restaurantFactory;
        this.gateway = gateway;
    }
    @Override
    public RestaurantResponseModel create(RestaurantRequestModel requestModel) {
        Restaurant restaurant = restaurantFactory.create(requestModel.getResName(), requestModel.getResCategory(),
                requestModel.getResLocation(), requestModel.getStars());
        RestaurantGatewayModel gatewayModel= new RestaurantGatewayModel(restaurant.getName(), restaurant.getResCategory(),
                restaurant.getLocation(), restaurant.getStars());
        gateway.loadRestaurant(gatewayModel);
        RestaurantResponseModel restaurantResponseModel = new RestaurantResponseModel(gateway.loadRestaurant(gatewayModel));
        return restaurantPresenter.prepareSuccessView(restaurantResponseModel);
    }

}
