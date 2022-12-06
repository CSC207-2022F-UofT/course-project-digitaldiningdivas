package APP_Business_Rules.RestaurantUseCase;

import Entities.Restaurant;

public class RestaurantFactory {
    /* Creates and stores Restaurant upon request from Account Owner
     */
    Restaurant create(String resName, String resCategory, String location, int stars){
        return new Restaurant(resName, resCategory, location, stars);
    }

}
