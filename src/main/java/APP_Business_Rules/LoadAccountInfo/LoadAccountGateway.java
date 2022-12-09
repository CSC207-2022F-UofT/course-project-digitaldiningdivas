package APP_Business_Rules.LoadAccountInfo;


public interface LoadAccountGateway {
    /**
     * This is an interface That used to Load Accounts.
     */

    boolean findAccountUser(String username);

    void save(UserAccountInfoModel model);

    UserAccountInfoModel load(String username);

    void change(String Username, String newbio);

}

