package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.LoginUser.LoginUserPresenter;
import APP_Business_Rules.LoginUser.LoginUserResponseModel;

public class LoginUserResponse implements LoginUserPresenter {
    @Override
    public LoginUserResponseModel userLoggedIn(LoginUserResponseModel model) {
        return model;
    }

    @Override
    public LoginUserResponseModel userLoginFail(String fail) {
        throw new LoginFail(fail);
    }
}
