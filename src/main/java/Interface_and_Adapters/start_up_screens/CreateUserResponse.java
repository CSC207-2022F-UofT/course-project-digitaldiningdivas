package Interface_and_Adapters.start_up_screens;

import APP_Business_Rules.CreateUser.CreateUserPresenter;
import APP_Business_Rules.CreateUser.CreateUserResponseModel;

public class CreateUserResponse implements CreateUserPresenter {
    @Override
    public CreateUserResponseModel userCreated(CreateUserResponseModel model) {
        return null;
    }

    @Override
    public CreateUserResponseModel userCreatedFail(String fail) {
        throw new SignUpFail(fail);
    }
}
