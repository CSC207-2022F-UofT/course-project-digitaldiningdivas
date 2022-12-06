package APP_Business_Rules.RestaurantUseCase;

import java.util.List;

public interface RestaurantDataAccess {
    boolean existsByName(String identifier);
    RestaurantGatewayModel loadRestaurant(RestaurantGatewayModel model);
    List<List<String>> getRes();

}
