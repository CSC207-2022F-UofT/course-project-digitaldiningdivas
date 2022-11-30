package Interface_and_Adapters.DishMenuScreens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishPopUp extends JPanel implements ActionListener {

    DishPopUp(String dishName, String restaurant, String starRating, String description, String category, String price){
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
        JLabel res = new JLabel("Restaurant: " + restaurant);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 3;
        c.gridy = 0;
        this.add(res, c);
        c = new GridBagConstraints();
        JLabel rating = new JLabel("Rating: " + starRating);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 4;
        c.gridy = 1;
        this.add(rating, c);
        c = new GridBagConstraints();
        JLabel dishDescription = new JLabel("Description: "+ description);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 1;
        this.add(dishDescription, c);

        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


}
