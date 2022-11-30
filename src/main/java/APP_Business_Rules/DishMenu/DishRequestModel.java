package APP_Business_Rules.DishMenu;

public class DishRequestModel {
    private String DishName;
    private String DishCategory;

    public DishRequestModel(String DishName, String DishCategory){
        this.DishName = DishName;
        this.DishCategory = DishCategory;
    }

    public String getDishCategory(){
        return DishCategory;
    }

    public String getDishName(){
        return DishName;
    }
}
