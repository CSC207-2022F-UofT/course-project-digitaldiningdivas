package Interface_and_Adapters.CreateReviewScreen;

import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreateReviewScreen extends JPanel implements ActionListener{

    public CreateReviewScreen(CreateReviewController controller, JPanel outerPanel, String author, String reviewed){

        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        layout.rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        this.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        JLabel name = new JLabel(reviewed);
        name.setFont(new Font("Sans Serif", Font.BOLD, 20));
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        this.add(name, c);

        c = new GridBagConstraints();
        String[] lst = {"1 Star", "2 Stars", "3 Stars", "4 Stars", "5 Stars",};
        JComboBox starRating = new JComboBox(lst);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 1;
        starRating.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    starRating.setVisible(true);
                    starRating.revalidate();
                    starRating.repaint();
                } else {
                    starRating.setVisible(false);
                }

            }
        });
        this.add(starRating, c);

        c = new GridBagConstraints();
        JTextArea writeReview = new JTextArea("Write your review!");
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 2;
        this.add(writeReview, c);


        c = new GridBagConstraints();
        JButton confirm = new JButton("Confirm");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 5;
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CreateReviewResponseModel newReview = controller.create(author, reviewed,
                        writeReview.getText(), starRating.getSelectedIndex() + 1);
                CardLayout card = (CardLayout) (outerPanel.getLayout());
                card.show(outerPanel, "card1");

            }
        });
        this.add(confirm, c);

        c = new GridBagConstraints();
        JButton cancel = new JButton("Cancel");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 1;
        c.gridy = 5;
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) (outerPanel.getLayout());
                card.show(outerPanel, "card1");

            }
        });
        this.add(cancel, c);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

