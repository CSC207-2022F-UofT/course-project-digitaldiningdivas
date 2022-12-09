package APP_Business_Rules.create_user;


import APP_Business_Rules.CreateReviewUseCase.CreateReviewResponseModel;
import Entities.AccountFactory;
import Entities.UserFactory;
import Frameworks_and_Drivers.UserFile;
import Interface_and_Adapters.start_up_screens.CreateUserController;
import Interface_and_Adapters.start_up_screens.CreateUserResponse;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;


class CreateUserInteractorTest {

    // seems impossible to create a functional test.
    // The use case is tested more practically by running the application.
    Random random = new Random();
    CreateUserGateway user = new UserFile("./users.csv");
    CreateUserPresenter presenter = new CreateUserResponse();
    UserFactory userFactory = new AccountFactory();
    CreateUserInputBoundary interactor = new CreateUserInteractor(
            user, userFactory, presenter);
    CreateUserController controller = new CreateUserController(interactor);
    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "x", "y", "z"};


    @Test
    void createNewUser() {
        String name = "";
        String password = "";
        while(user.findAccountUser("John")&&name.equals("")){
            name = alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)];
            password = alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)] + alphabet[random.nextInt(26)];
        }
        CreateUserResponseModel res = controller.create(name, password, password);
        assert user.findAccountUser(name);
    }
}