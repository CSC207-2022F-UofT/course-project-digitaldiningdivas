package APP_Business_Rules.DishMenu;

public class DishResponseModel {
    String dish;
    public DishResponseModel(String dish){
        this.dish = dish;
    }

    public String getRestaurant(){
        return dish;
    }

    public void setRestaurant(String dish) {
        this.dish = dish;
    }
}
