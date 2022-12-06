package APP_Business_Rules.restaurant_use_case;

public class RestaurantResponseModel {
    RestaurantGatewayModel model;

    public RestaurantResponseModel(RestaurantGatewayModel model) {
        this.model = model;
    }

    public String getRestaurantName() {
        return this.model.getResName();
    }

    public String getCategory() {
        return this.model.getResCategory();
    }

    public String getLocation() {
        return this.model.getResLocation();
    }

    public int getStars() {
        return this.model.getStars();
    }

}
