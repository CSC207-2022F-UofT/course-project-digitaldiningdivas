package Interface_and_Adapters.DishMenuScreens;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewGateway;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInputBoundary;
import APP_Business_Rules.CreateReviewUseCase.CreateReviewInteractor;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsGateway;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInputBoundary;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInteractor;
import Frameworks_and_Drivers.ReviewFile;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewController;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewFormatted;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewPresenter;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewScreen;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsController;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsFormatted;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsPresenter;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsScreen;

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
     * @param mainPanel: the main panel in the jframe
     * @param account: The account currently logged in
     */
    public DishPopUp(String dishName, String starRating, String description, String category,
                     String price, JPanel mainPanel, String account){
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

        JButton resReviewsButton = new JButton("See reviews"); //Allows user to add review for this Restaurant
        resReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayReviewsGateway revGate = new ReviewFile();
                DisplayReviewsPresenter disRev = new DisplayReviewsFormatted();
                DisplayReviewsInputBoundary inBoundRev = new DisplayReviewsInteractor(revGate, disRev);
                DisplayReviewsController disRevController = new DisplayReviewsController(inBoundRev);
                DisplayReviewsScreen seeReviews = new DisplayReviewsScreen(disRevController,
                        mainPanel, dishName);
                mainPanel.add(seeReviews, "seeReviews");
                CardLayout card = (CardLayout) (mainPanel.getLayout());
                card.show(mainPanel, "seeReviews");

            }
        });
        this.add(resReviewsButton);
        this.setVisible(true);

        JButton ReviewsButton = new JButton("new review"); //Allows user to add review for this Restaurant
        ReviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReviewGateway revGate = new ReviewFile();
                CreateReviewPresenter disRev = new CreateReviewFormatted();
                CreateReviewInputBoundary inBoundRev = new CreateReviewInteractor(revGate, disRev);
                CreateReviewController disRevController = new CreateReviewController(inBoundRev);
                CreateReviewScreen writeReview = new CreateReviewScreen(disRevController,
                        mainPanel, account, dishName);
                mainPanel.add(writeReview, "writeReview");
                CardLayout card = (CardLayout) (mainPanel.getLayout());
                card.show(mainPanel, "writeReview");

            }
        });
        this.add(ReviewsButton);
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