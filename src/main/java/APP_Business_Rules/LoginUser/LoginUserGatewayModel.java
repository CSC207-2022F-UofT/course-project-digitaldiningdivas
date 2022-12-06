package APP_Business_Rules.LoginUser;

import java.io.Serializable;

public class LoginUserGatewayModel implements Serializable {

    private final String username;

    LoginUserGatewayModel(String username){

        this.username = username;

    }

    public String getUsername() {return username;}
}
