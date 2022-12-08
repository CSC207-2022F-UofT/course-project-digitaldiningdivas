package Interface_and_Adapters.DisplayReviewsScreen;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;
import Interface_and_Adapters.CreateReviewScreen.CreateReviewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DisplayReviewsPopUp extends JPanel {


    public DisplayReviewsPopUp(String author, String rating, String review, String resOrDish, String createdOn,
                               DisplayReviewsController controller, JPanel outerPanel){

        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        this.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel(resOrDish);
        name.setFont(new Font("Sans Serif", Font.BOLD, 20));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.add(name, c);

        c = new GridBagConstraints();
        JLabel writer = new JLabel(author);
        writer.setFont(new Font("Sans Serif", Font.BOLD, 20));
        writer.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(writer, c);

        c = new GridBagConstraints();
        JLabel sRating = new JLabel(rating);
        sRating.setFont(new Font("Sans Serif", Font.BOLD, 20));
        sRating.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 3;
        c.gridy = 0;
        this.add(sRating, c);

        c = new GridBagConstraints();
        JLabel dateMade = new JLabel(createdOn);
        dateMade.setFont(new Font("Sans Serif", Font.BOLD, 20));
        dateMade.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 5;
        this.add(dateMade, c);


        c = new GridBagConstraints();
        JTextArea writtenReview = new JTextArea(review);
        writtenReview.setEditable(false);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 4;
        c.gridheight = 3;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 2;
        this.add(writtenReview, c);



        c = new GridBagConstraints();
        JButton cancel = new JButton("Cancel");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.25;
        c.weighty = 0.25;
        c.gridx = 0;
        c.gridy = 0;
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (outerPanel.getLayout());
                card.show(outerPanel, "seeReviews");

            }
        });
        this.add(cancel, c);


        this.setVisible(true);
    }


}





