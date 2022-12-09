package Interface_and_Adapters;

import APP_Business_Rules.DishMenu.*;
import APP_Business_Rules.RestaurantUseCase.*;
//import APP_Business_Rules.RestaurantUseCase.RestaurantFormatted;
import APP_Business_Rules.SearchUseCase.SearchDishInteractor;
import APP_Business_Rules.SearchUseCase.SearchRestaurantInteractor;
import Interface_and_Adapters.SearchScreen.SearchController;
import Interface_and_Adapters.SearchScreen.SearchPresenter;
import Interface_and_Adapters.SearchScreen.SearchScreen;
import Interface_and_Adapters.start_up_screens.ProfileScreen;
import Interface_and_Adapters.restaurant_screens.*;




import APP_Business_Rules.login_user.LoginUserResponseModel;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import APP_Business_Rules.DishMenu.DishPresenter;
import Interface_and_Adapters.DishMenuScreens.DishScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class TabPanel extends JPanel{
    private JPanel mainPanel;
    private LoginUserResponseModel account;

    public TabPanel(JPanel mainPanel, LoginUserResponseModel account) throws IOException {
        this.mainPanel = mainPanel;
        this.account = account;

        JTabbedPane tabs = new JTabbedPane();
        this.setLayout(new CardLayout());

        RestaurantDataAccess res;
        res = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");
//
//        DishDataAccess dish = new DishFileReader("src/main/java/Frameworks_and_Drivers/Dishes.csv");
//
//
        RestaurantPresenter presenter = new RestaurantFormatted();
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantInputBoundary interactor = new RestaurantInteractor(
                res, presenter, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(
                interactor);
//
//
//        DishPresenter dishPresenter = new DishFormatted();
//        DishFactory dishFactory = new DishFactory();
//        DishInputBoundary dishInteractor = new DishInteractor(dish, dishPresenter, dishFactory);
//        DishController dishController = new DishController(dishInteractor);
//
//
//
        ProfileScreen welcomeScreen = new ProfileScreen(account, mainPanel);
//
//
//        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController, account.getUsername());
//        DishScreen dishScreen = new DishScreen(dishController);

//        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
//        RankingScreen rankingScreen = new RankingScreen();

        SearchPresenter searchPresenter = new SearchPresenter();
        DishFileReader dishFileReader = new DishFileReader("Dish.csv");
        RestaurantFileReader restaurantFileReader = new RestaurantFileReader("Restaurant.csv");
        SearchDishInteractor searchDishInteractor = new SearchDishInteractor(searchPresenter, dishFileReader);
        SearchRestaurantInteractor searchRestaurantInteractor = new SearchRestaurantInteractor(searchPresenter, restaurantFileReader);
        SearchController searchController = new SearchController(searchDishInteractor, searchRestaurantInteractor);
        SearchScreen searchScreen = new SearchScreen(searchController, mainPanel, account.getUsername(), restaurantController);
        searchPresenter.setView(searchScreen);

        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Home", welcomeScreen);
        tabs.addTab("Search", searchScreen.$$$getRootComponent$$$());

        this.add(tabs);
        //JOptionPane.showMessageDialog(this, "Welcome " + account.getUsername() + "!");
    }
}
