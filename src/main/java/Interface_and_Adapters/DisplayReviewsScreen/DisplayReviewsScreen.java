package Interface_and_Adapters.DisplayReviewsScreen;

import Entities.Review;
import Frameworks_and_Drivers.ReviewFile;
import APP_Business_Rules.DisplayReviewsUseCase.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayReviewsScreen extends JPanel implements ActionListener {

    DisplayReviewsController displayReviewsController;

    public DisplayReviewsScreen(DisplayReviewsController displayReviewsController,
                                JPanel mainPanel, String resOrDish) {
        this.displayReviewsController = displayReviewsController;

        JPanel subPanel2 = new JPanel(); //panel for button grid

        subPanel2.setLayout(new GridLayout(0, 1, 10, 10));
        subPanel2.setBorder(new EmptyBorder(20, 50, 40, 50));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() { //button brings user back into RestaurantScreen
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayReviewsScreen.this.switchPanel(mainPanel, "FOURTH"); //returns to first screen by button click
            }

        });
        this.add(backButton);

        DisplayReviewsGateway reviewListReader;
        reviewListReader = new ReviewFile();
        List<Review> revList = reviewListReader.retrieveReviews(resOrDish);
        if (revList.isEmpty()) {
            JLabel none = new JLabel("No reviews yet");
            subPanel2.add(none);

        }
        else {
            for (Review review : revList) {
                JButton button = new JButton(review.getAuthor() + ", " + review.getRatingString());
                button.setBorderPainted(false);
                subPanel2.add(button, c);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    //opens restaurant window with jbuttons from "home" screen
                    {
                        DisplayReviewsPopUp popUp = new DisplayReviewsPopUp(review.getAuthor(), review.getRatingString(),
                                review.getReview(), review.getReviewed(), review.getCreatedOn(),
                                displayReviewsController, mainPanel);
                        mainPanel.add(popUp, "details");
                        CardLayout card = (CardLayout) (mainPanel.getLayout());
                        card.show(mainPanel, "details");

                    }
                });
                c.gridy += 1;
            }
        }
        JScrollPane scroller = new JScrollPane(subPanel2);
        scroller.setPreferredSize(new Dimension(1200, 700));
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scroller, "listOfReviews");
        this.add(subPanel2);


    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

