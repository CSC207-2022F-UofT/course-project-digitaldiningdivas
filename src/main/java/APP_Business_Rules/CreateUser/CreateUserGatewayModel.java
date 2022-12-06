package APP_Business_Rules.CreateUser;

import java.io.Serializable;

public class CreateUserGatewayModel implements Serializable {

    private final String username;

    private final String password;

    CreateUserGatewayModel(String username, String password){

        this.username = username;
        this.password = password;
    }
    public String getUsername() {return username;}

    public String getPassword() {return password;}
}
