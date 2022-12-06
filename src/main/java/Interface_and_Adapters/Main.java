package Interface_and_Adapters;


import APP_Business_Rules.CreateUser.*;
import APP_Business_Rules.LoginUser.*;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.AccountUserFile;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.start_up_screens.*;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

    public Main() {
        CreateUserGateway user;
        user = new UserFile("./users.csv");
        CreateUserPresenter presenter = new CreateUserResponse();
        UserFactory userFactory = new AccountFactory();
        CreateUserInputBoundary interactor = new CreateUserInteractor(
                user, userFactory, presenter);
        CreateUserController controller = new CreateUserController(interactor);
        //
        LoginUserGateway user2;
        user2 = new UserFile("./users.csv");
        AccountUserGateway account2;
        account2 = new AccountUserFile("./accounts.csv");
        LoginUserPresenter presenter2 = new LoginUserResponse();
        UserFactory userFactory2 = new AccountFactory();
        LoginUserInputBoundary interactor2 = new LoginUserInteractor(
                user2, account2, userFactory2, presenter2);
        LoginUserController controller2 = new LoginUserController(interactor2);
        //

        this.setTitle("Digital Dining Divas");
        this.setResizable(false);
        this.setSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(new StartUpScreen(mainPanel), "FIRST");
        mainPanel.add(new SignUpScreen(controller, mainPanel), "SECOND");
        mainPanel.add(new LoginScreen(controller2, mainPanel), "THIRD");
        this.setContentPane(mainPanel);

    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }
}
