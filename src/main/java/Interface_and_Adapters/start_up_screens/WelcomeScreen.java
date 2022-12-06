package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.LoginUser.LoginUserResponseModel;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JPanel {

    LoginUserResponseModel account;

    public WelcomeScreen(LoginUserResponseModel account){
        this.account = account;

        JLabel title = new JLabel();
        title.setText("Welcome " + account.getUsername() + "!");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(title);

    }
}
