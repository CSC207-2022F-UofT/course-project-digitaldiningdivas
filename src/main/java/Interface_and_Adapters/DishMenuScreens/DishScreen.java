package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.DishMenu.DishDataAccess;
import APP_Business_Rules.DishMenu.DishFileReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


/**
 * The dish screen class that formats and displays dish information to the UI.
 */
public class DishScreen extends JPanel implements ActionListener {

    DishController dishController;

    /**
     * The constructor for the DishScreen when activated.
     * @param dishController: The given controller for the instantiation of the DishScreen.
     * @param account: The account currently logged in
     */
    public DishScreen(DishController dishController, String account) throws IOException {
        CardLayout cards = new CardLayout();
        this.setLayout(cards);

        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new CardLayout());

        JPanel subPanel = new JPanel(); //panel for button grid

        subPanel.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel.setBorder(new EmptyBorder(20,50,40,50));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        this.dishController = dishController;

        DishDataAccess dishes;
        dishes = new DishFileReader("src/main/java/Frameworks_and_Drivers/Dishes.csv");

        for(String key: dishes.getDish("src/main/java/Frameworks_and_Drivers/Dishes.csv").keySet()){
            List<List<String>> dishList = dishes.getDish("src/main/java/Frameworks_and_Drivers/Dishes." +
                    "csv").get(key);
            for (List<String> element : dishList) {
                JButton button = new JButton(element.get(0) + " (" + key + ")");
                button.setBorderPainted(false);
                subPanel.add(button, c);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    //opens restaurant window with jbuttons from "home" screen
                    {
                        DishPopUp popUp = new DishPopUp(element.get(0), element.get(1), element.get(2), element.get(3),
                                element.get(4), DishScreen.this, account);
                        DishScreen.this.add(popUp, "card1");
                        GridBagConstraints c = new GridBagConstraints();
                        JButton backButton = new JButton("Back");
                        popUp.add(backButton);
                        backButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                CardLayout cardLayout = (CardLayout) DishScreen.this.getLayout();
                                cardLayout.first(DishScreen.this); //returns to first screen by button click
                            }

                        });
                        cards.show(DishScreen.this, "card1");

                    }
                });
                c.gridy += 1;
            }
        }
        JScrollPane scroller = new JScrollPane(subPanel);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scroller);


    }

    /**
     * A method for when an action is performed within the menu.
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}