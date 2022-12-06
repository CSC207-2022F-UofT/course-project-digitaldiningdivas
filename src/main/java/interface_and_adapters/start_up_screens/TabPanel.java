package interface_and_adapters.start_up_screens;

import APP_Business_Rules.dish_menu.*;
import APP_Business_Rules.restaurant_use_case.*;

import APP_Business_Rules.login_user.LoginUserResponseModel;
import interface_and_adapters.*;
import interface_and_adapters.dish_menu_screens.DishController;
import interface_and_adapters.dish_menu_screens.DishFormatted;
import APP_Business_Rules.dish_menu.DishPresenter;
import interface_and_adapters.dish_menu_screens.DishScreen;
import interface_and_adapters.ranking.RankingScreen;

import javax.swing.*;
import java.io.IOException;


public class TabPanel extends JPanel{
    private JPanel mainPanel;
    private LoginUserResponseModel account;

    public TabPanel(JPanel mainPanel, LoginUserResponseModel account) throws IOException {
        this.mainPanel = mainPanel;
        this.account = account;

        JTabbedPane tabs = new JTabbedPane();

        RestaurantDataAccess res;
        res = new RestaurantFileReader("src/main/java/Frameworks_and_Drivers/Restaurant.csv");

        DishDataAccess dish = new DishFileReader("Dishes.csv");


        RestaurantPresenter presenter = new RestaurantFormatted();
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        RestaurantInputBoundary interactor = new RestaurantInteractor(
                res, presenter, restaurantFactory);
        RestaurantController restaurantController = new RestaurantController(
                interactor);

        DishPresenter dishPresenter = new DishFormatted();
        DishFactory dishFactory = new DishFactory();
        DishInputBoundary dishInteractor = new DishInteractor(dish, dishPresenter, dishFactory);
        DishController dishController = new DishController(dishInteractor);

        WelcomeScreen welcomeScreen = new WelcomeScreen(account);
        RestaurantScreen restaurantScreen = new RestaurantScreen(restaurantController);
        DishScreen dishScreen = new DishScreen(dishController);

        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
        RankingScreen rankingScreen = new RankingScreen();

        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Home", welcomeScreen);
        tabs.addTab("Restaurant", restaurantScreen);
        tabs.addTab("Rankings", rankingScreen);
        tabs.addTab("Analytics", analyticsScreen);
        tabs.addTab("Dishes", dishScreen);

        this.add(tabs);
        //JOptionPane.showMessageDialog(this, "Welcome " + account.getUsername() + "!");
    }
}
