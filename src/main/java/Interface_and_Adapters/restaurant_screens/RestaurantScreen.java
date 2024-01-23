package Interface_and_Adapters.restaurant_screens;

import APP_Business_Rules.RestaurantUseCase.*;
import Entities.Account;
import Interface_and_Adapters.DishMenuScreens.DishController;
import Interface_and_Adapters.DishMenuScreens.DishScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class RestaurantScreen extends JPanel {
    /* Displays Restaurant information to the user.
     */
    RestaurantController restaurantController;
    String account;
    DishController dishController;

    public RestaurantScreen(RestaurantController restaurantController, String account, DishController dishController) {
        this.restaurantController = restaurantController;
        this.account = account;
        this.dishController = dishController;
        JPanel outerPanel = new JPanel();
        //panel to switch between restaurant screen and restaurant popup
        outerPanel.setLayout(new CardLayout());
        JPanel subPanel = new JPanel(); //panel for button grid

        subPanel.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel.setBorder(new EmptyBorder(20, 50, 40, 50));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        RestaurantDataAccess restaurants;
        restaurants = new RestaurantFileReader("./Restaurant.csv");

        //creates a list of buttons that contain all restaurant names
        for (List<String> element : restaurants.getRes()) {
            // element.get(0) is a restaurant name
            JButton button = new JButton(element.get(0));
            button.setPreferredSize(new Dimension(40, 40));
            button.setBorderPainted(false);
            subPanel.add(button, c);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                //opens restaurant popup with jbuttons on the restaurant screen
                {
                    RestaurantPopUp popUp = new RestaurantPopUp(element.get(0), element.get(1),
                            element.get(2), element.get(3), account, restaurantController, outerPanel, dishController);
                    outerPanel.add(popUp, "card1");
                    switchPanel(outerPanel, "card1");

                }
            });
            c.gridy += 1;
        }
        JScrollPane scroller = new JScrollPane(subPanel);
        scroller.setPreferredSize(new Dimension(1200, 700));
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outerPanel.add(scroller, "one");
        this.add(outerPanel);
    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

}