package APP_Business_Rules.DishMenu;

import Entities.Dish;

public class DishFactory {
    /* Creates and stores Dish upon request from Account Owner
     */
    public Dish create(String DishName, String DishCategory){
        return new Dish(DishName, DishCategory);
    }
}

