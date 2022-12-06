package APP_Business_Rules.LoginUser;



public interface LoginUserPresenter {

    LoginUserResponseModel userLoggedIn(LoginUserResponseModel model);

    LoginUserResponseModel userLoginFail(String fail);
}
