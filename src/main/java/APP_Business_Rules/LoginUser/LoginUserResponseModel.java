package APP_Business_Rules.LoginUser;

public class LoginUserResponseModel {

    LoginUserGatewayModel model;


    public LoginUserResponseModel(LoginUserGatewayModel model) {
        this.model = model;
    }

    public String getUsername(){
        return this.model.getUsername();
    }
}
