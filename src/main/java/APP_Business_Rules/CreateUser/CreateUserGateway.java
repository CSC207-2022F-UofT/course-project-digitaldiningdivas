package APP_Business_Rules.CreateUser;

public interface CreateUserGateway {

    boolean findAccountUser(String username);

    void save(CreateUserGatewayModel model);
}
