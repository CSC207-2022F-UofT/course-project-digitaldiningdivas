package Interface_and_Adapters.SearchScreen;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsGateway;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInputBoundary;
import APP_Business_Rules.DisplayReviewsUseCase.DisplayReviewsInteractor;
import APP_Business_Rules.login_user.LoginUserResponseModel;
import Entities.Restaurant;
import Frameworks_and_Drivers.ReviewFile;
import Interface_and_Adapters.DishMenuScreens.DishPopUp;
import Interface_and_Adapters.DishMenuScreens.DishScreen;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsController;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsFormatted;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsPresenter;
import Interface_and_Adapters.DisplayReviewsScreen.DisplayReviewsScreen;
import Interface_and_Adapters.UI;
import Interface_and_Adapters.restaurant_screens.RestaurantController;
import Interface_and_Adapters.restaurant_screens.RestaurantPopUp;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchScreen implements UI {
    String[] header = {"Name", "Category", "Address", "Rating", "Price"};
    private JTabbedPane tabbedPane;
    private JPanel ResearchPanel;
    private JPanel Restaurant;
    private JPanel Dish;
    private JTextField restaurantSearchTextField;
    private JButton restaurantSearchButton;
    private JTable restaurantTable;
    private JPanel restaurantFilters;
    private JComboBox restaurantCategoryComboBox;
    private JLabel restaurantCategoryLabel;
    private JLabel restaurantRatingLabel;
    private JSpinner restaurantRatingSpinner;
    private JTextField dishSearchTextField;
    private JButton dishSearchButton;
    private JTable dishTable;
    private JPanel dishfilters;
    private JComboBox dishCategoryComboBox;
    private JSpinner dishRatingSpinner;
    private JLabel dishCategoryLabel;
    private JLabel dishRatingLabel;
    private JScrollPane restaurantTableScrollPane;
    private JScrollPane dishTableScrollPane;
    private String currentUser; //Variable that represents current user
    private SearchController searchController;

    public SearchScreen(SearchController searchController, JPanel mainPanel, String account, RestaurantController restaurantController) {
        this.searchController = searchController;

        //Show the search panel
        CardLayout card = (CardLayout) ResearchPanel.getLayout();
        card.show(ResearchPanel, "appCard");

        //Search buttons listeners
        dishSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchController.Search(dishSearchTextField.getText(), "Dish", (String) dishCategoryComboBox.getSelectedItem(), (int) dishRatingSpinner.getValue());
            }
        });

        restaurantSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchController.Search(restaurantSearchTextField.getText(), "Restaurant", (String) restaurantCategoryComboBox.getSelectedItem(), (int) restaurantRatingSpinner.getValue());
            }
        });

        //Set up categories name
        setUpCategories();

        //Add listener to rows of restaurant table to display reviews
        restaurantTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = restaurantTable.getSelectedRow();
                if (rowIndex != -1) {
                    RestaurantPopUp popUp = new RestaurantPopUp((String) restaurantTable.getValueAt(rowIndex,0), (String) restaurantTable.getValueAt(rowIndex,1),
                            (String) restaurantTable.getValueAt(rowIndex,2), (String) restaurantTable.getValueAt(rowIndex,3), account, restaurantController, mainPanel);
                    mainPanel.add(popUp, "card1");
                    switchPanel(mainPanel, "card1");
                }
            }
        });

        //Add listener to rows of dish table to display reviews
        dishTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = dishTable.getSelectedRow();
                if (rowIndex != -1) {
                    //opens restaurant window with jbuttons from "home" screen
                    DishPopUp popUp = new DishPopUp((String) dishTable.getValueAt(rowIndex, 0), (String) dishTable.getValueAt(rowIndex, 1), (String) dishTable.getValueAt(rowIndex, 2), (String) dishTable.getValueAt(rowIndex, 3),
                            (String) dishTable.getValueAt(rowIndex, 4), mainPanel, account);
                    mainPanel.add(popUp, "card1");
                    JButton backButton = new JButton("Back");
                    popUp.add(backButton);
                    backButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            switchPanel(mainPanel, "FOURTH"); //returns to first screen by button click
                        }

                    });
                    switchPanel(mainPanel, "card1");


                }
            }
        });
    }

    //Set up the category items
    public void setUpCategories() {
        dishCategoryComboBox.addItem("All");
        restaurantCategoryComboBox.addItem("All");
        List<String> record = new ArrayList<>();
        for (int i = 0; i < restaurantTable.getModel().getRowCount(); i++) {
            if (!record.contains(restaurantTable.getModel().getValueAt(i, 1))) {
                record.add((String) restaurantTable.getModel().getValueAt(i, 1));
                restaurantCategoryComboBox.addItem(restaurantTable.getModel().getValueAt(i, 1));
            }
        }
        for (int i = 0; i < dishTable.getModel().getRowCount(); i++) {
            if (!record.contains(dishTable.getModel().getValueAt(i, 3))) {
                record.add((String) dishTable.getModel().getValueAt(i, 3));
                dishCategoryComboBox.addItem(dishTable.getModel().getValueAt(i, 3));
            }
        }
    }

    //Change the Restaurant table
    public void updateRestaurantTable(String[][] data) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        restaurantTable.setModel(model);
        for (String[] d : data) {
            model.addRow(d);
        }
    }

    //Change Dish table
    @Override
    public void updateDishTable(String[][] data) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        dishTable.setModel(model);
        for (String[] d : data) {
            model.addRow(d);
        }
    }

    //Default Restaurant and dish table
    public void defaultTable() {
        //Setting up default data displayed of the search tab
        searchController.Search("", "Restaurant", "All", 0);
        searchController.Search("", "Dish", "All", 0);
    }

    public JPanel getResearchPanel() {
        return ResearchPanel;
    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        ResearchPanel = new JPanel();
        ResearchPanel.setLayout(new CardLayout(0, 0));
        tabbedPane = new JTabbedPane();
        ResearchPanel.add(tabbedPane, "appCard");
        Restaurant = new JPanel();
        Restaurant.setLayout(new GridBagLayout());
        tabbedPane.addTab("Restaurants", Restaurant);
        restaurantSearchTextField = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 3.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Restaurant.add(restaurantSearchTextField, gbc);
        restaurantSearchButton = new JButton();
        restaurantSearchButton.setText("Search");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Restaurant.add(restaurantSearchButton, gbc);
        restaurantTable = new JTable();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 3.0;
        gbc.weighty = 20.0;
        gbc.fill = GridBagConstraints.BOTH;
        Restaurant.add(restaurantTable, gbc);
        restaurantFilters = new JPanel();
        restaurantFilters.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        Restaurant.add(restaurantFilters, gbc);
        restaurantCategoryComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        restaurantFilters.add(restaurantCategoryComboBox, gbc);
        restaurantCategoryLabel = new JLabel();
        restaurantCategoryLabel.setText("Category:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        restaurantFilters.add(restaurantCategoryLabel, gbc);
        restaurantRatingLabel = new JLabel();
        restaurantRatingLabel.setText("Rating:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        restaurantFilters.add(restaurantRatingLabel, gbc);
        restaurantRatingSpinner = new JSpinner();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        restaurantFilters.add(restaurantRatingSpinner, gbc);
        Dish = new JPanel();
        Dish.setLayout(new GridBagLayout());
        tabbedPane.addTab("Dish", Dish);
        dishSearchTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 3.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Dish.add(dishSearchTextField, gbc);
        dishSearchButton = new JButton();
        dishSearchButton.setText("Search");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Dish.add(dishSearchButton, gbc);
        dishTable = new JTable();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.weightx = 3.0;
        gbc.weighty = 20.0;
        gbc.fill = GridBagConstraints.BOTH;
        Dish.add(dishTable, gbc);
        dishfilters = new JPanel();
        dishfilters.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        Dish.add(dishfilters, gbc);
        dishCategoryComboBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dishfilters.add(dishCategoryComboBox, gbc);
        dishRatingLabel = new JLabel();
        dishRatingLabel.setText("Rating");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dishfilters.add(dishRatingLabel, gbc);
        dishRatingSpinner = new JSpinner();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dishfilters.add(dishRatingSpinner, gbc);
        dishCategoryLabel = new JLabel();
        dishCategoryLabel.setText("Category");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        Dish.add(dishCategoryLabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return ResearchPanel;
    }
}
