package Interface_and_Adapters;

import APP_Business_Rules.DishMenu.*;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishFormatted;
import Interface_and_Adapters.DishMenuScreens.DishPresenter;
import Interface_and_Adapters.DishMenuScreens.DishScreen;
import Interface_and_Adapters.Ranking.RankingScreen;

import javax.swing.*;
import java.io.IOException;

public class DishMenuMain {

    public static void main(String[] args) throws IOException {
        /*
        Adds screens to a JTabbedPane.
         */
        JFrame frame = new JFrame("Digital Dining Divas");
        JTabbedPane tabs = new JTabbedPane();

        DishDataAccess dish;
        dish = new DishFileReader("src/main/java/Frameworks_and_Drivers/Dish.csv");


        DishPresenter presenter = new DishFormatted();
        DishFactory dishFactory = new DishFactory();
        DishInputBoundary interactor = new DishInteractor(
               dish, presenter, dishFactory);
        DishController dishController = new DishController(
                interactor);

        DishScreen dishScreen = new DishScreen(dishController);

        AnalyticsScreen analyticsScreen = new AnalyticsScreen();
        RankingScreen rankingScreen = new RankingScreen();


        //adds windows with labels to tab layout. This is an example of what a Restaurant Owner would see.
        tabs.addTab("Dishes", dishScreen);
        tabs.addTab("Rankings", rankingScreen);
        tabs.addTab("Analytics", analyticsScreen);



        //adds tab layout to jFrame
        frame.getContentPane().add(tabs);

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }



}
