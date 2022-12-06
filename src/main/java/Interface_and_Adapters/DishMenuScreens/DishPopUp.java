package Interface_and_Adapters.DishMenuScreens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Dish popup menu that appears when clicking on the dish in the DishScreen.
 */
public class DishPopUp extends JPanel implements ActionListener {

    /**
     * Contructor that instantiates a new dish popUp menu.
     * @param dishName: String name of the dish for the popup
     * @param starRating: The String rating of the dish for the popup
     * @param description: The String description for the dish in the popup
     * @param category: The string category of the dish.
     * @param price: A string of the price of the dish in the popup.
     */
    DishPopUp(String dishName, String starRating, String description, String category, String price){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel(dishName);
        name.setFont(new Font("Sans Serif", Font.BOLD, 20));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 0;
        this.add(name, c);

        c = new GridBagConstraints();
        JLabel rating = new JLabel("Rating: " + starRating);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 4;
        c.gridy = 1;
        this.add(rating, c);
        c = new GridBagConstraints();
        JLabel dishPrice = new JLabel("Price: $" + price);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 4;
        c.gridy = 0;
        this.add(dishPrice, c);
        c = new GridBagConstraints();
        JLabel dishDescription = new JLabel("Description: "+ description);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 1;
        this.add(dishDescription, c);
        c = new GridBagConstraints();
        JLabel dishCategory = new JLabel("Category: " + category);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 3;
        c.gridy = 0;
        this.add(dishCategory, c);

        this.setVisible(true);
    }

    /**
     * Method for an action performed within the popup.
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


}