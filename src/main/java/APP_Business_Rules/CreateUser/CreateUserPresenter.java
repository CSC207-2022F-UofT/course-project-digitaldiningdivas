package APP_Business_Rules.CreateUser;

public interface CreateUserPresenter {

    CreateUserResponseModel userCreated(CreateUserResponseModel model);

    CreateUserResponseModel userCreatedFail(String fail);
}
