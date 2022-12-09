package Interface_and_Adapters;


import APP_Business_Rules.create_user.*;

import APP_Business_Rules.login_user.LoginUserResponseModel;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.start_up_screens.*;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    private LoginUserResponseModel account;

    public Main() {
        CreateUserGateway user;
        user = new UserFile("./users.csv");
        CreateUserPresenter presenter = new CreateUserResponse();
        UserFactory userFactory = new AccountFactory();
        CreateUserInputBoundary interactor = new CreateUserInteractor(
                user, userFactory, presenter);
        CreateUserController controller = new CreateUserController(interactor);

        //

        this.setTitle("Digital Dining Divas");
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(new StartUpScreen(mainPanel), "FIRST");
        mainPanel.add(new SignUpScreen(controller, mainPanel), "SECOND");
        this.setContentPane(mainPanel);

    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);

    }

    public void setAccount(LoginUserResponseModel account) {
        this.account = account;
    }
}
