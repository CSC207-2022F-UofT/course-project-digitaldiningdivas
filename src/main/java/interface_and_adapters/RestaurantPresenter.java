package interface_and_adapters;


import APP_Business_Rules.restaurant_use_case.RestaurantResponseModel;
public interface RestaurantPresenter {
    public RestaurantResponseModel prepareSuccessView(RestaurantResponseModel responseModel);
}