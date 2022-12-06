package APP_Business_Rules.restaurant_use_case;

import java.util.List;

public interface RestaurantDataAccess {
    boolean existsByName(String identifier);
    RestaurantGatewayModel loadRestaurant(RestaurantGatewayModel model);
    List<List<String>> getRes();

}
